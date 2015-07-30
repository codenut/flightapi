package com.flight.api.util;

import au.com.bytecode.opencsv.CSVReader;
import com.flight.api.model.Airlines;
import com.flight.api.model.Cities;
import com.flight.api.model.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Util {
    private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

    private static Map<Route, Airlines> csvToDict(CSVReader reader) {
        try {
            Map<Route, Airlines> routeDict = new HashMap<>();

            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                String from = nextLine[0];
                String to = nextLine[1];

                put(routeDict, new Route(from, to), nextLine[2]);
                put(routeDict, new Route(to, from), nextLine[2]);
            }

            return routeDict;
        } catch(IOException ex) {
            ex.printStackTrace();
        }

        throw new IllegalArgumentException();
    }

    private static Map<Route, Airlines> csvToDict(InputStream inputStream) {
        try (CSVReader reader = new CSVReader(new InputStreamReader(inputStream, "utf-8"))) {
            return csvToDict(reader);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    public static Map<Route, Airlines> csvToDict(String filename) {
        try {
            LOGGER.info("Reading from custom data file: " + filename);
            return csvToDict(new FileInputStream(filename));
        } catch(FileNotFoundException fosEx) {
            fosEx.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    public static Map<Route, Airlines> csvToDict() {
        return csvToDict(Helper.getInputStream("routes.csv"));
    }

    public static Cities getCities(Map<Route, Airlines> airlinesMap) {
        Cities cities = new Cities();
        for(Route route : airlinesMap.keySet()) {
            cities.getCities().add(route.getFrom());
            cities.getCities().add(route.getTo());
        }
        return cities;
    }

    private static void put(Map<Route, Airlines> map, Route route, String value) {
        if(!map.containsKey(route)) {
            map.put(route, new Airlines());
        }
        map.get(route).getAirlines().add(value);
    }
}
