/**
 * Created by maritvandijk on 4/1/17.
 */
public class TestGreetingController {

    // TODO: complete tests to check output & output with name

    private final String BASE_URL = "http://localhost:8080/greeting";
    // Expect: {"id":1,"content":"Hello, World!"}
    private final String BASE_URL_WITH_PARAM = "http://localhost:8080/greeting?name=";
    // Expect: {"id":2,"content":"Hello, User!"}

    public String name = "";


}
