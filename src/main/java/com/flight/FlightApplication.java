package com.flight;

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
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.Map;

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

        final RouteResource routeResource = new RouteResource(routeCache);
        final CitiesResource citiesResource = new CitiesResource(Util.getCities(routeCache));

        Injector injector = createInjector();
        //environment.jersey().register(routeResource);
        environment.jersey().register(injector.getInstance(RouteResource.class));
        environment.jersey().register(citiesResource);
    }

    private Injector createInjector() {
        return Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(RouteDao.class).to(RouteService.class);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new FlightApplication().run(args);
    }
}
