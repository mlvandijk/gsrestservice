package cucumber.stepdefs;

import cucumber.GreetingServiceSteps;
import cucumber.api.PendingException;
import cucumber.api.java8.En;

/**
 * Created by maritvandijk on 4/2/17.
 */
public class GreetingServiceStepDefs implements En{

    public GreetingServiceSteps greetingServiceSteps;

    public GreetingServiceStepDefs(){
        Given("^the greeting service is running$", () -> {
            // Write code here that turns the phrase above into concrete actions
//            throw new PendingException();
        });

        When("^the client requests /GET /greeting$", () -> {
            try {
                greetingServiceSteps.theClientRequestsGETGreeting();
            } catch (Throwable t) {
                System.out.println("Throwable caught");
                t.printStackTrace();
            }
        });

        Then("^the response should be JSON:$", (String arg1) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }

}
