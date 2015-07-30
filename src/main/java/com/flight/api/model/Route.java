package com.flight.api.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Objects;

@JacksonXmlRootElement(localName = "root")
public class Route {
    private String from;
    private String to;

    public Route() {
    }

    public Route(String from, String to) {
        this();
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Route)) {
            return false;
        }
        Route that = (Route) o;
        return this.from.equalsIgnoreCase(that.from) && this.to.equalsIgnoreCase(that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.to.toLowerCase(), this.from.toLowerCase());
    }

    @Override
    public String toString() {
        return this.from + "-" + this.to;
    }
}
