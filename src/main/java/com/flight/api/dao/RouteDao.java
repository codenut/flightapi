package com.flight.api.dao;

import com.flight.api.model.Airlines;
import com.flight.api.model.Route;

/**
 * Created by michael on 7/30/15.
 */
public interface RouteDao {
    public Airlines findAirlines(String from, String to);

    public Airlines findAirlines(Route route);
}
