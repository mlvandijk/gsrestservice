package cucumber.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

/**
 * Created by maritvandijk on 4/2/17.
 */
public class GreetingServiceStepDefs implements En{

    public GreetingServiceStepDefs(){
        Given("^the greeting service is running$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        When("^the client requests /GET /greeting$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

        Then("^the response should be JSON:$", (String arg1) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }

}
