package com.flight.api.resources;

import com.flight.api.model.Airlines;
import com.flight.api.model.FlightResponse;
import com.flight.api.model.Route;
import com.flight.api.util.Constants;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/route")
@Produces(MediaType.APPLICATION_XML)
public class RouteResource {
    private Map<Route, Airlines> routeCache;

    public RouteResource(Map<Route, Airlines> routeDict) {
        this.routeCache = routeDict;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public FlightResponse post(Route route) {
        if(routeCache.containsKey(route)) {
            return routeCache.get(route);
        } else {
            return new FlightResponse(Constants.ROUTE_NOT_FOUND);
        }
    }
}
