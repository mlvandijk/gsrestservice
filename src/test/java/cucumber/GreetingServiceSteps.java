package cucumber;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.Greeting;
import org.junit.Assert;

import java.net.HttpURLConnection;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GreetingServiceSteps {
    private ClientResponse response;

    private final String BASE_URL = "http://localhost:8080/greeting";
    private final String BASE_URL_WITH_NAME_QUERY_PARAM = "http://localhost:8080/greeting?name=";

    public void theClientRequestsGETGreeting() throws Throwable {
        try {
            getResponse(BASE_URL);
        } catch (RuntimeException r) {
            throw r;
        } catch (Exception e) {
            System.out.println("Exception caught");
            e.printStackTrace();
        }

        Assert.assertEquals("Did not receive ok response: ", HttpURLConnection.HTTP_OK, response.getStatus());
    }

    public void theClientRequestsGETGreetingUsingQueryStringParameter(String user) throws Throwable {
        try {
            String url = BASE_URL_WITH_NAME_QUERY_PARAM + user;
            getResponse(url);
        } catch (RuntimeException r) {
            throw r;
        } catch (Exception e) {
            System.out.println("Exception caught");
            e.printStackTrace();
        }

        Assert.assertEquals("Did not receive ok response: ", HttpURLConnection.HTTP_OK, response.getStatus());
    }

    public void theResponseShouldBeJSON(String jsonExpected) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Greeting greeting = mapper.readValue(jsonExpected, Greeting.class);
            String expectedValue = greeting.getContent();
            String actualValue = mapper.readValue(response.getEntity(String.class), Greeting.class).getContent();
            Assert.assertEquals("Unexpected JSON.", expectedValue, actualValue);
        } catch (Exception e) {
            System.out.println("Exception caught");
            e.printStackTrace();
        }

    }

    private ClientResponse getResponse(String url) {
        Client client = new Client();
        WebResource webResource = client.resource(url);
        return response = webResource.type("application/json").get(ClientResponse.class);
    }


}
