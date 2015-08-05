package com.flight.api.dao;

import com.flight.api.model.Cities;
import com.google.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by michael on 8/5/15.
 */
public class CityService implements CityDao{
    @PersistenceContext
    @Inject
    private EntityManager em;

    public Cities getAllCities() {

        Query query = em.createQuery(
            "SELECT distinct(r.from) FROM Route r"
        );

        Cities cities = new Cities();

        cities.getCities().addAll(
                (List<String>) query.getResultList()
                                .stream()
                                .map(o -> o.toString().trim())
                                .collect(Collectors.toList())
        );

        return cities;
    }
}
