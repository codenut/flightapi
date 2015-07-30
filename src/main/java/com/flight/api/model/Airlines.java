package com.flight.api.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Set;
import java.util.TreeSet;

@JacksonXmlRootElement(localName = "root")
public class Airlines extends FlightResponse {
    @JacksonXmlElementWrapper(useWrapping = false)
    private Set<String> airlines;

    public Airlines() {
        this.airlines = new TreeSet<>();
    }

    public Set<String> getAirlines() {
        return airlines;
    }

    public void setAirlines(Set<String> airlines) {
        this.airlines = airlines;
    }

}
