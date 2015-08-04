package com.flight.api.resources;

import com.flight.api.dao.RouteDao;
import com.flight.api.model.Airlines;
import com.flight.api.model.FlightResponse;
import com.flight.api.model.Route;
import com.flight.api.util.Constants;
import com.google.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/route")
@Produces(MediaType.APPLICATION_XML)
public class RouteResource {
    private RouteDao routeDao;

    @Inject
    public RouteResource(RouteDao routeDao) {
        this.routeDao = routeDao;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public FlightResponse post(Route route) {
        Airlines result = routeDao.findAirlines(route);
        if(result.getAirlines().size() > 0) {
            return result;
        } else {
            return new FlightResponse(Constants.ROUTE_NOT_FOUND);
        }
    }

    @GET
    @Path("/{from}/{to}")
    public Airlines get(@PathParam("from") String from,
                           @PathParam("to") String to) {
        return routeDao.findAirlines(from, to);
    }
}
