package com.flight.api.resources;

import com.flight.api.model.Airlines;
import com.flight.api.model.FlightResponse;
import com.flight.api.model.Route;
import com.flight.api.util.Util;
import com.flight.api.util.Constants;
import io.dropwizard.testing.junit.ResourceTestRule;
import junit.framework.Assert;
import org.glassfish.jersey.test.grizzly.GrizzlyTestContainerFactory;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RouteResourceTest {
    @ClassRule
    public static final ResourceTestRule RULE = ResourceTestRule.builder()
            .setTestContainerFactory(new GrizzlyTestContainerFactory())
            .addResource(new RouteResource(Util.csvToDict()))
            .build();

    @Test
    public void testPostResource() {
        Route route = new Route("Tokyo", "Manila");
        Airlines expected = new Airlines();
        expected.getAirlines().add("Cebu Pacific");
        expected.getAirlines().add("All Nippon Airways");
        expected.getAirlines().add("Delta Air Lines");
        expected.getAirlines().add("Japan Airlines");

        final Response response =
                RULE.getJerseyTest().target("/route").request().post(Entity.entity(route, MediaType.APPLICATION_XML));

        Airlines airlines = response.readEntity(Airlines.class);
        Assert.assertEquals(response.getStatusInfo(), Response.Status.OK);
        Assert.assertEquals(expected.getAirlines(), airlines.getAirlines());
    }

    @Test
    public void testPostResourceReverseDirection() {
        Route route = new Route("Tokyo", "Manila");
        Airlines expected = new Airlines();
        expected.getAirlines().add("Cebu Pacific");
        expected.getAirlines().add("All Nippon Airways");
        expected.getAirlines().add("Delta Air Lines");
        expected.getAirlines().add("Japan Airlines");

        final Response response =
                RULE.getJerseyTest().target("/route").request().post(Entity.entity(route, MediaType.APPLICATION_XML));

        Airlines airlines = response.readEntity(Airlines.class);
        Assert.assertEquals(response.getStatusInfo(), Response.Status.OK);
        Assert.assertEquals(expected.getAirlines(), airlines.getAirlines());
    }

    @Test
    public void TestPostResourceNotMatchFound() {
        Route route = new Route("asldfjasdf", "asdf");

        final Response response =
                RULE.getJerseyTest().target("/route").request().post(Entity.entity(route, MediaType.APPLICATION_XML));

        Assert.assertEquals(Constants.ROUTE_NOT_FOUND, response.readEntity(FlightResponse.class).getError());
    }
}
