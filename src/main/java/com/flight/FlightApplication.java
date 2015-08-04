package com.flight;

import com.flight.api.config.DatabaseConfiguration;
import com.flight.api.config.FlightApplicationConfiguration;
import com.flight.api.dao.RouteDao;
import com.flight.api.dao.RouteService;
import com.flight.api.model.Airlines;
import com.flight.api.model.Route;
import com.flight.api.resources.CitiesResource;
import com.flight.api.resources.RouteResource;
import com.flight.api.util.Util;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.Map;
import java.util.Properties;

public class FlightApplication extends Application<FlightApplicationConfiguration> {

    @Override
    public void initialize(Bootstrap<FlightApplicationConfiguration> bootstrap) {
    }

    @Override
    public void run(FlightApplicationConfiguration configuration, Environment environment) {
        Map<Route, Airlines> routeCache;

        if(configuration.getData() == null) {
            routeCache = Util.csvToDict();
        } else {
            routeCache = Util.csvToDict(configuration.getData());
        }

        final CitiesResource citiesResource = new CitiesResource(Util.getCities(routeCache));

        Injector injector = createInjector(configuration);
        PersistService pse = injector.getInstance(PersistService.class);
        pse.start();

        //environment.jersey().register(routeResource);
        environment.jersey().register(injector.getInstance(RouteResource.class));
        environment.jersey().register(citiesResource);
    }

    private Injector createInjector(FlightApplicationConfiguration configuration) {
        return Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(RouteDao.class).to(RouteService.class);
            }
        }, createJpaModule(configuration.getDatabase()));
    }

    private JpaPersistModule createJpaModule(DatabaseConfiguration configuration) {
        Properties properties = new Properties();
        properties.put("javax.persistence.jdbc.driver", configuration.getDriverClass());
        properties.put("javax.persistence.jdbc.user", configuration.getUser());
        properties.put("javax.persistence.jdbc.password", configuration.getPassword());
        properties.put("javax.persistence.jdbc.url", configuration.getUrl());

        JpaPersistModule jpa = new JpaPersistModule("Default");
        jpa.properties(properties);

        return jpa;
    }

    public static void main(String[] args) throws Exception {
        new FlightApplication().run(args);
    }
}
