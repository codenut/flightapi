package com.flight.api.resources;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.flight.api.dao.CityDao;
import com.flight.api.model.Cities;
import com.google.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cities")
@Produces(MediaType.APPLICATION_XML)
public class CitiesResource {
    private CityDao cityDao;

    @Inject
    public CitiesResource(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @GET
    @Consumes(MediaType.APPLICATION_XML)
    @JacksonXmlElementWrapper(localName = "cities")
    public Cities get() {
        return cityDao.getAllCities();
    }
}
