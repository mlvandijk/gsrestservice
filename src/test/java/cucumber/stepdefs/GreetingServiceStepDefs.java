package cucumber.stepdefs;

import cucumber.GreetingServiceSteps;
import cucumber.api.java8.En;
import hello.Application;
import org.springframework.boot.SpringApplication;

public class GreetingServiceStepDefs implements En {

    private GreetingServiceSteps greetingServiceSteps = new GreetingServiceSteps();

    public GreetingServiceStepDefs() {
        Given("^the greeting service is running$", () -> {
            try {
                SpringApplication.run(Application.class);
            } catch (Throwable t) {
                System.out.println("The service cannot start, it is likely already running.");
            }
        });

        When("^the client requests /GET /greeting$", () -> {
            try {
                greetingServiceSteps.theClientRequestsGETGreeting();
            } catch (Throwable t) {
                System.out.println("Throwable caught");
                t.printStackTrace();
            }
        });

        When("^the client requests /GET /greeting using query string parameter (.*)$", (String user) -> {
            try {
                greetingServiceSteps.theClientRequestsGETGreetingUsingQueryStringParameter(user);
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
