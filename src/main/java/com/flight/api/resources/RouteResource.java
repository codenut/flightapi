package com.flight.api.resources;

import com.flight.api.core.Airlines;
import com.flight.api.core.FlightResponse;
import com.flight.api.core.Route;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/route")
@Produces(MediaType.APPLICATION_XML)
public class RouteResource {
    private Map<Route, Airlines> routeDict;

    public RouteResource(Map<Route, Airlines> routeDict) {
        this.routeDict = routeDict;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public FlightResponse post(Route route) {
        if(routeDict.containsKey(route)) {
            return routeDict.get(route);
        } else {
            return new FlightResponse("Route not found.");
        }
    }
}
