package com.flight.api.services;

import com.flight.api.dao.RoutesDao;
import com.flight.api.model.Airlines;

/**
 * Created by michael on 8/4/15.
 */
public class RoutesService implements RoutesDao {
    public Airlines getAirlines(String from, String to) {
        Airlines airlines = new Airlines();

        return airlines;
    }
}
