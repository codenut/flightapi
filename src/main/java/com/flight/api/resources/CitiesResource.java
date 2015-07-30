package com.flight.api.resources;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.flight.api.model.Cities;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cities")
@Produces(MediaType.APPLICATION_XML)
public class CitiesResource {
    private Cities cities;

    public CitiesResource(Cities cities) {
        this.cities = cities;
    }

    @GET
    @Consumes(MediaType.APPLICATION_XML)
    @JacksonXmlElementWrapper(localName = "cities")
    public Cities get() {
        return this.cities;
    }
}
