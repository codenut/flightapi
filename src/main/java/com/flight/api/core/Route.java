package com.flight.api.core;

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
        this.from = from.toLowerCase();
        this.to = to.toLowerCase();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from.toLowerCase();
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to.toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Route)) {
            return false;
        }
        Route that = (Route) o;
        return this.from.equals(that.from) && this.to.equals(that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.to, this.from);
    }

    @Override
    public String toString() {
        return this.from + "-" + this.to;
    }
}
