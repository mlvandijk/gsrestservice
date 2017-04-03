package cucumber.stepdefs;

import cucumber.GreetingServiceSteps;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import hello.Application;
import org.springframework.boot.SpringApplication;

/**
 * Created by maritvandijk on 4/2/17.
 */
public class GreetingServiceStepDefs implements En{

    public GreetingServiceSteps greetingServiceSteps = new GreetingServiceSteps();

    public GreetingServiceStepDefs(){
        Given("^the greeting service is running$", () -> {
            SpringApplication.run(Application.class);
        });

        When("^the client requests /GET /greeting$", () -> {
            try {
                greetingServiceSteps.theClientRequestsGETGreeting();
            } catch (Throwable t) {
                System.out.println("Throwable caught");
                t.printStackTrace();
            }
        });

        Then("^the response should be JSON:", (String jsonExpected) -> {
            try {
                greetingServiceSteps.theResponseShouldBeJSON(jsonExpected);
            } catch (Throwable t) {
                System.out.println("Throwable caught");
                t.printStackTrace();
            }
        });
    }
}
