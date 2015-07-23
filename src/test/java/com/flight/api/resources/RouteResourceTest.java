package com.flight.api.resources;

import com.flight.api.core.Route;
import com.flight.api.util.CSVUtil;
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
            .addResource(new RouteResource(CSVUtil.csvToDict()))
            .build();

    @Test
    public void testPostResource() {
        Route route = new Route("Tokyo", "Manila");

        final Response response =
                RULE.getJerseyTest().target("/route").request().post(Entity.entity(route, MediaType.APPLICATION_XML));

        Assert.assertEquals(response.getStatusInfo(), Response.Status.OK);
    }
}
