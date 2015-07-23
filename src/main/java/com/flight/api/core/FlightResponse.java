package com.flight.api.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "root")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightResponse {
    private String message;

    public FlightResponse() {
    }

    public FlightResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
