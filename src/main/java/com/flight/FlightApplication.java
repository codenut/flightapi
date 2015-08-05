package com.flight;

import com.flight.api.config.FlightApplicationConfiguration;
import com.flight.api.resources.CitiesResource;
import com.flight.api.resources.RouteResource;
import com.flight.api.util.Util;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class FlightApplication extends Application<FlightApplicationConfiguration> {

    @Override
    public void initialize(Bootstrap<FlightApplicationConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<FlightApplicationConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(FlightApplicationConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(FlightApplicationConfiguration configuration, Environment environment) {
        Injector injector = Util.createInjector(configuration);
        PersistService pse = injector.getInstance(PersistService.class);
        pse.start();

        environment.jersey().register(injector.getInstance(RouteResource.class));
        environment.jersey().register(injector.getInstance(CitiesResource.class));
    }

    public static void main(String[] args) throws Exception {
        new FlightApplication().run(args);
    }
}
