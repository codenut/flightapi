package com.flight.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "root")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightResponse {
    private String error;

    public FlightResponse() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public FlightResponse(String error) {

        this.error = error;
    }
}
