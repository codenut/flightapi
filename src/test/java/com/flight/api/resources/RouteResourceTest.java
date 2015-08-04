package com.flight.api.resources;

import com.flight.FlightApplication;
import com.flight.api.config.FlightApplicationConfiguration;
import com.flight.api.model.Airlines;
import com.flight.api.model.FlightResponse;
import com.flight.api.model.Route;
import com.flight.api.util.Constants;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RouteResourceTest {

    @ClassRule
    public static final DropwizardAppRule<FlightApplicationConfiguration> RULE =
        new DropwizardAppRule<FlightApplicationConfiguration>(FlightApplication.class,
                ResourceHelpers.resourceFilePath("example.mysql.yml"));

    private static Client client;
    private static WebTarget target;

    @Before
    public void setup() {
        client = new JerseyClientBuilder(RULE.getEnvironment()).build("test client");
        target = client.target(String.format("http://localhost:%d/route", RULE.getLocalPort()));
    }

    @After
    public void close() {
        if(client != null) {
            client.close();
        }
    }

    @Test
    public void testPostResource() {
        Route route = new Route("Tokyo", "Manila");

        final Response response = target.request().post(Entity.entity(route, MediaType.APPLICATION_XML));

        Airlines airlines = response.readEntity(Airlines.class);
        Assert.assertEquals(response.getStatusInfo(), Response.Status.OK);
        Assert.assertNotNull(airlines);
        Assert.assertNotEquals(airlines.getAirlines().size(), 0);

    }

    @Test
    public void TestPostResourceNotMatchFound() {
        Route route = new Route("asldfjasdf", "asdf");

        final Response response = target.request().post(Entity.entity(route, MediaType.APPLICATION_XML));

        Assert.assertEquals(Constants.ROUTE_NOT_FOUND, response.readEntity(FlightResponse.class).getError());
    }
}
