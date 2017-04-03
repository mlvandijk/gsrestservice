package cucumber;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParser;
import hello.Greeting;
import org.junit.Assert;

import java.net.HttpURLConnection;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


/**
 * Created by maritvandijk on 4/2/17.
 */
public class GreetingServiceSteps {
    private ClientResponse response;

    private String name;
    private final String BASE_URL = "http://localhost:8080/greeting";
    private final String BASE_URL_WITH_PARAM = "http://localhost:8080/greeting?name=" + name;

    public void theClientRequestsGETGreeting() throws Throwable{
        try {
            Client client = new Client();

            WebResource webResource = client.resource(BASE_URL); // TODO: Use server hooks (cucumber for java)

            response = webResource.type("application/json").get(ClientResponse.class);


        } catch (RuntimeException r) {
            throw r;
        } catch (Exception e) {
            System.out.println("Exception caught");
            e.printStackTrace();
        }

        Assert.assertEquals("Did not receive ok response: ", HttpURLConnection.HTTP_OK, response.getStatus());
    }

    public void theResponseShouldBeJSON(String jsonExpected){
        ObjectMapper mapper = new ObjectMapper();
//        String jsonInString = jsonExpected;
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


}
