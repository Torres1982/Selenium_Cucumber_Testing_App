package stepdefinition;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class SearchStepDefinition {
	public WebDriver webDriver;
	
	@Given("^User is on the eBay main page$")
	public void user_is_on_ebay_main_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AR20068603\\chromedriver.exe");
		webDriver = new ChromeDriver();
		
	}
	
	@When("^User search for \"([^\"]*)\" items$")
	public void user_search_for_shoes_items(String itemName) throws Throwable {
		
	}
	
	@Then("^\"([^\"]*)\" results are displayed on the page$")
	public void shoes_results_are_displayed_on_page(String itemName) throws Throwable {
		
	}

	@When("^added the items to a cart$")
	public void added_the_items_to_a_cart() throws Throwable {

	}

	@When("^User proceeded to the Checkout page to buy the items$")
	public void user_proceeded_to_the_Checkout_page_to_buy_the_items() throws Throwable {

	}

	@Then("^verified selected items are displayed on the Checkout page$")
	public void verified_selected_items_are_displayed_on_the_Checkout_page() throws Throwable {

	}
}
