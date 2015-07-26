package com.flight.api.core;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Set;
import java.util.TreeSet;

@JacksonXmlRootElement(localName = "root")
public class Cities extends FlightResponse {
    @JacksonXmlElementWrapper(useWrapping = false)
    private Set<String> cities;

    public Cities() {
        this.cities = new TreeSet<>();
    }

    public Set<String> getCities() {
        return cities;
    }

    public void setCities(Set<String> cities) {
        this.cities = cities;
    }
}
