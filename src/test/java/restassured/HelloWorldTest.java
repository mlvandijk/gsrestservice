package restassured;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HelloWorldTest {
    private final String BASE_URL = "http://localhost:8080/greeting";

    @Test
    public void EnsureHelloWorldIsRunning() {
        given().when().get(BASE_URL).then().statusCode(200);
    }


    @Test
    public void AssertHelloWorldBody() {
        given().
                when().
                get(BASE_URL).
                then().
                body("content", equalTo("Hello, World!"));
    }


    @Test
    public void AssertHelloWorldBodyWithQueryParameter() {
        given().
                queryParam("name", "Koen").
                when().
                get(BASE_URL).
                then().
                body("content", equalTo("Hello, Koen!"));
    }
}