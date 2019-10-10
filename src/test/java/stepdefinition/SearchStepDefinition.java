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
import util.ChromeWebDriverUtility;

@RunWith(Cucumber.class)
public class SearchStepDefinition {
	public WebDriver webDriver;
	
	@Given("^User is on the online shop landing page$")
	public void user_is_on_football_shop_online_main_page() throws Throwable {
		webDriver = ChromeWebDriverUtility.getWebDriver();
	}
	
	@When("^User search for \"([^\"]*)\" items$")
	public void user_search_for_selected_items(String itemName) throws Throwable {
		webDriver.findElement(By.cssSelector("input[name='search']")).sendKeys(itemName);
	}
	
	@Then("^\"([^\"]*)\" results are displayed on the page$")
	public void wallet_results_are_displayed_on_page(String itemName) throws Throwable {
		webDriver.get("https://www.faishop.com/index.php?route=product/search&search=Jersey&description=true");
		Assert.assertTrue(webDriver.findElements(By.xpath("//h4[@class='name']/a")).get(0).getText().contains(itemName));
	}
	
	@And("^\"([^\"]*)\" model results are displayed on the page$")
	public void model_results_are_displayed_on_page(String itemName) throws Throwable {
		String transformedItemName = itemName.toLowerCase();
		webDriver.get("https://www.faishop.com/index.php?route=product/search&search=Football&description=true");
		Assert.assertTrue(webDriver.findElements(By.xpath("//h4[@class='name']/a")).get(0).getText().toLowerCase().contains(transformedItemName));
	}

	@And("^User proceeded to the Checkout page to buy the items$")
	public void user_proceeded_to_the_checkout_page_to_buy_the_items() throws Throwable {
		webDriver.findElements(By.xpath("//div[@class='image ']/a/img")).get(0).click();
		webDriver.findElement(By.cssSelector("button#button-cart.button")).click();
		
		// TODO: Apply switching to a Modal Window
		webDriver.findElement(By.xpath("//div[@id='cart']/button")).click();
		webDriver.findElement(By.xpath("//div[@class='mini-cart-total']/p/a[1]")).click();
	}

	@Then("^verified selected \"([^\"]*)\" items are displayed on the Checkout page$")
	public void verified_selected_items_are_displayed_on_the_checkout_page(String itemName) throws Throwable {
		String transformedItemName = itemName.toLowerCase();
		//webDriver.findElement(By.xpath("//span[@class='order-summary-toggle__text order-summary-toggle__text--show']/span")).click();
		Assert.assertTrue(webDriver.findElement(By.xpath("//td[@class='text-left name']/a[1]")).getText().toLowerCase().contains(transformedItemName));
	}
}
