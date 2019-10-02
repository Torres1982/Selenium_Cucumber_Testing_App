package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinition {
    @Given("^User is on the Home Page$")
    public void user_is_on_the_home_page() throws Throwable {
    	System.out.println("User has navigated to the Home Page!");
    }
    
    @When("^User logs in with a username \"([^\"]*)\" and passwrod \"([^\"]*)\"$")
    public void user_logs_in_with_a_username_and_passwrod(String arg1, String arg2) throws Throwable {
    	System.out.println("User logged in with a Username and Password!");
    }

    @Then("^User accesses their profile page$")
    public void user_accesses_their_profile_page() throws Throwable {
    	System.out.println("User accessed their Profile Page!");
    }

    @And("^User can access his personal details$")
    public void user_can_access_his_personal_details() throws Throwable {
    	System.out.println("User can access their Personal Details!");
    }
    
    @Then("^User cannot access all personal details$")
    public void user_cannot_access_all_personal_details() throws Throwable {
    	System.out.println("User cannot access all Personal Details!");
    }
}
