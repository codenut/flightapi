package com.flight.api.dao;

import com.flight.api.model.Route;

import java.util.List;

/**
 * Created by michael on 7/30/15.
 */
public interface RouteDao {
    public List<Route> findAirlines(Route route);
}
