package com.flight;

import com.flight.api.config.FlightApplicationConfiguration;
import com.flight.api.model.Airlines;
import com.flight.api.model.Route;
import com.flight.api.resources.CitiesResource;
import com.flight.api.resources.RouteResource;
import com.flight.api.util.Util;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.Map;

public class FlightApplication extends Application<FlightApplicationConfiguration> {

    @Override
    public void initialize(Bootstrap<FlightApplicationConfiguration> bootstrap) {
    }

    @Override
    public void run(FlightApplicationConfiguration configuration, Environment environment) {
        final DBIFactory dbiFactory = new DBIFactory();
        Map<Route, Airlines> routeCache;

        if(configuration.getData() == null) {
            routeCache = Util.csvToDict();
        } else {
            routeCache = Util.csvToDict(configuration.getData());
        }

        final RouteResource routeResource = new RouteResource(routeCache);
        final CitiesResource citiesResource = new CitiesResource(Util.getCities(routeCache));

        environment.jersey().register(routeResource);
        environment.jersey().register(citiesResource);
    }

    public static void main(String[] args) throws Exception {
        new FlightApplication().run(args);
    }
}
