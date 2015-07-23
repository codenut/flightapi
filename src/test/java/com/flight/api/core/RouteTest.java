package com.flight.api.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.dropwizard.testing.FixtureHelpers;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;

public class RouteTest {
    private final ObjectMapper MAPPER = new XmlMapper();

    @Test
    public void serializesToXML() throws IOException {
        final Route route = new Route("Singapore", "Tokyo");
        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(FixtureHelpers.fixture("fixtures/route.xml"), Route.class));

        Assert.assertEquals(MAPPER.writeValueAsString(route), expected);
    }

    @Test
    public void serializesFromXML() throws IOException {
        final Route route = new Route("Singapore", "Tokyo");
        final Route expected = MAPPER.readValue(FixtureHelpers.fixture("fixtures/route.xml"), Route.class);

        Assert.assertEquals(route, expected);
    }
}
