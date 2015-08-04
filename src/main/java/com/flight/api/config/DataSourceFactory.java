package com.flight.api.config;

/**
 * Created by michael on 8/4/15.
 */
public class DataSourceFactory {
    private String user;
    private String password;
    private String driverClass;
    private String url;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {

        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
