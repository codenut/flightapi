package com.flight;

import io.dropwizard.Configuration;

/**
 * Created by michael on 7/23/15.
 */

public class FlightApplicationConfiguration extends Configuration {
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
