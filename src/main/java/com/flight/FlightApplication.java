package com.flight;

import com.flight.api.core.Airlines;
import com.flight.api.core.Route;
import com.flight.api.resources.CitiesResource;
import com.flight.api.resources.RouteResource;
import com.flight.api.util.CSVUtil;
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
            routeCache = CSVUtil.csvToDict();
        } else {
            routeCache = CSVUtil.csvToDict(configuration.getData());
        }

        final RouteResource routeResource = new RouteResource(routeCache);
        final CitiesResource citiesResource = new CitiesResource(CSVUtil.getCities(routeCache));

        environment.jersey().register(routeResource);
        environment.jersey().register(citiesResource);
    }

    public static void main(String[] args) throws Exception {
        new FlightApplication().run(args);
    }
}
