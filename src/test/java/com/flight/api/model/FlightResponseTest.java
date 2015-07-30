package com.flight.api.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.flight.api.util.Constants;
import io.dropwizard.testing.FixtureHelpers;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by michael on 7/23/15.
 */
public class FlightResponseTest {
    private final ObjectMapper MAPPER = new XmlMapper();

    @Test
    public void serializesToXML() throws IOException {
        final FlightResponse response = new FlightResponse(Constants.ROUTE_NOT_FOUND);

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(FixtureHelpers.fixture("fixtures/message.xml"), FlightResponse.class));

        Assert.assertEquals(MAPPER.writeValueAsString(response), expected);
    }

    @Test
    public void deserializesToXML() throws IOException {
        final FlightResponse response = new FlightResponse(Constants.ROUTE_NOT_FOUND);

        final FlightResponse expected = MAPPER.readValue(FixtureHelpers.fixture("fixtures/message.xml"), FlightResponse.class);

        Assert.assertEquals(response.getError(), expected.getError());
    }
}
