package com.flight.api.dao;

import com.flight.api.model.Airlines;
import com.flight.api.model.Route;
import com.google.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by michael on 7/30/15.
 */
public class RouteService implements RouteDao {
    @PersistenceContext
    @Inject
    private EntityManager em;

    public Airlines findAirlines(String from, String to) {
        javax.persistence.Query query = em.createQuery(
                "SELECT DISTINCT(r.airline) FROM Route r WHERE " +
                "(r.from = :from AND r.to = :to) or " +
                "(r.from = :to and r.to = :from)");

        query.setParameter("from", from.trim());
        query.setParameter("to", to.trim());

        List<String> airlines = (List<String>)query.getResultList()
                                .stream()
                                .map(r -> r.toString())
                                .collect(Collectors.toList());

        return new Airlines(new TreeSet<>(airlines));
    }

    public Airlines findAirlines(Route route) {
        return findAirlines(route.getFrom(), route.getTo());
    }
}
