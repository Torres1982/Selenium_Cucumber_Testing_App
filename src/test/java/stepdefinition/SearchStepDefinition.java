package stepdefinition;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import util.WebDriverUtility;

@RunWith(Cucumber.class)
public class SearchStepDefinition {
	public WebDriver webDriver;
	
	@Given("^User is on the eBay main page$")
	public void user_is_on_ebay_main_page() throws Throwable {
		webDriver = WebDriverUtility.getWebDriver();
		webDriver.get("https://www.ebay.ie");
	}
	
	@When("^User search for \"([^\"]*)\" items$")
	public void user_search_for_shoes_items(String itemName) throws Throwable {
		webDriver.findElement(By.cssSelector(".gh-tb.ui-autocomplete-input")).sendKeys(itemName);
	}
	
	@Then("^\"([^\"]*)\" results are displayed on the page$")
	public void shoes_results_are_displayed_on_page(String itemName) throws Throwable {
		webDriver.get("https://www.ebay.ie/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=Shoes&_sacat=0");
		Assert.assertTrue(webDriver.findElement(By.className("vip")).getText().contains(itemName));
	}
	
	@And("^\"([^\"]*)\" model results are displayed on the page$")
	public void model_results_are_displayed_on_page(String itemName) throws Throwable {
		String transformedItemName = itemName.toLowerCase();
		webDriver.get("https://www.ebay.ie/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=Nike&_sacat=0");
		Assert.assertTrue(webDriver.findElement(By.className("vip")).getText().toLowerCase().contains(transformedItemName));
	}

	@And("^User proceeded to the Checkout page to buy the items$")
	public void user_proceeded_to_the_Checkout_page_to_buy_the_items() throws Throwable {
		webDriver.findElements(By.cssSelector(".vip")).get(0).click();
		webDriver.findElement(By.cssSelector("#binBtn_btn")).click();
		webDriver.findElement(By.cssSelector("#sbin-gxo-btn")).click();
	}

	@Then("^verified selected \"([^\"]*)\" items are displayed on the Checkout page$")
	public void verified_selected_items_are_displayed_on_the_Checkout_page(String itemName) throws Throwable {
		String transformedItemName = itemName.toLowerCase();
		Assert.assertTrue(webDriver.findElement(By.className(".item-title")).getText().toLowerCase().contains(transformedItemName));
	}
}
