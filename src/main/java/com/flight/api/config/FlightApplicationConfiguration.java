package com.flight.api.config;

import io.dropwizard.Configuration;

import javax.validation.Valid;

/**
 * Created by michael on 7/23/15.
 */

public class FlightApplicationConfiguration extends Configuration {
    private String version;

    @Valid
    private DatabaseConfiguration database;

    private String data;

    public DatabaseConfiguration getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseConfiguration database) {
        this.database = database;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
