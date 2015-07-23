package com.flight.api.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.dropwizard.testing.FixtureHelpers;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by michael on 7/23/15.
 */
public class AirlinesTest {
    private final ObjectMapper MAPPER = new XmlMapper();

    @Test
    public void serializesToXML() throws IOException {
        final Airlines airlines = new Airlines();
        airlines.getAirlines().add("All Nippon Airways");
        airlines.getAirlines().add("Cebu Pacific");

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(FixtureHelpers.fixture("fixtures/airlines.xml"), Airlines.class));

        Assert.assertEquals(MAPPER.writeValueAsString(airlines), expected);
    }

    @Test
    public void deserializesFromXML() throws IOException {
        final Airlines airlines = new Airlines();
        airlines.getAirlines().add("All Nippon Airways");
        airlines.getAirlines().add("Cebu Pacific");

        final Airlines expected = MAPPER.readValue(FixtureHelpers.fixture("fixtures/airlines.xml"), Airlines.class);

        Assert.assertEquals(airlines.getAirlines(), expected.getAirlines());
    }
}
