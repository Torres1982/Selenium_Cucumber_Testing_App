package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.util.List;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinition {
    @Given("^User is on the Home Page$")
    public void user_is_on_the_home_page() throws Throwable {
    	System.out.println("User has navigated to the Home Page");
    }
    
    @When("^User logs in with a username \"([^\"]*)\" and passwrod \"([^\"]*)\"$")
    public void user_logs_in_with_a_username_and_passwrod(String username, String password) throws Throwable {
    	System.out.println("User logged in with a Username: " + username + " and Password: " + password);
    }

    @Then("^User accesses their profile page$")
    public void user_accesses_their_profile_page() throws Throwable {
    	System.out.println("User accessed their Profile Page");
    }

    @And("^User can access all personal details: \"([^\"]*)\"$")
    public void user_can_access_all_personal_details(String access) throws Throwable {
    	System.out.println("User can access all Personal Details: " + access + "\n");
    }
    
    @When("^User register with following details$")
    public void user_register_with_following_details(DataTable dataTable) throws Throwable {
    	List<List<String>> list = dataTable.raw();
    	
    	System.out.println("User Registers with following details:");					
    	
    	for (int i = 0; i < list.size(); i++) {
			System.out.println("\nName: " + list.get(i).get(0) +
								"\nPassword: " + list.get(i).get(1) +
								"\nEmail: " + list.get(i).get(2) +
								"\nNationality: " + list.get(i).get(3));
    	}
    }
    
    @When("^User logs in with a username (.+) and password (.+)$")
    public void user_logs_in_with_following_username_and_password(String username, String password) throws Throwable {
    	System.out.println("Username: " + username + ", Password: " + password);
    }
    
    @When("^User is not registered$")
    public void user_is_not_registered() throws Throwable {
    	System.out.println("User is not registered in the system");
    }
    
    @When("^User click the Registration Button$")
    public void user_click_the_Registration_Button() throws Throwable {
    	System.out.println("User clicked the Registration Button");
    }

    @Then("^The Error Message is displayed$")
    public void the_Error_Message_is_displayed() throws Throwable {
    	System.out.println("Registration Error Message is displayed");
    }

    @Then("^User is redirected to the login page$")
    public void user_is_redirected_to_the_login_page() throws Throwable {
    	System.out.println("User is redirected to the Login Page");
    }
}
