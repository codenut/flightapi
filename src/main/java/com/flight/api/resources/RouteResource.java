package com.flight.api.resources;

import com.flight.api.dao.RouteDao;
import com.flight.api.model.Airlines;
import com.flight.api.model.FlightResponse;
import com.flight.api.model.Route;
import com.flight.api.util.Constants;
import com.google.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("/route")
@Produces(MediaType.APPLICATION_XML)
public class RouteResource {
    private RouteDao routeDao;

    @Inject
    public RouteResource(RouteDao routeDao) {
        this.routeDao = routeDao;
    }

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

    @GET
    public List<Route> get(Route route) {
        return routeDao.findAirlines(route);
    }
}
