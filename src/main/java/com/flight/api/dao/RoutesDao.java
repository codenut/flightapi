package com.flight.api.dao;

import com.flight.api.model.Airlines;

/**
 * Created by michael on 8/4/15.
 */
public interface RoutesDao {
    public Airlines getAirlines(String from, String to);
}
