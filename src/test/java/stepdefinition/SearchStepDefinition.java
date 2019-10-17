package stepdefinition;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public void item_results_are_displayed_on_page(String itemName) throws Throwable {
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
		// Declare By's
		By mainAddToCartButton = By.cssSelector("div[id='cart'] button a");
		By miniCartButton = By.cssSelector("div[class='mini-cart-total'] p a");
		
		webDriver.findElements(By.xpath("//h4[@class='name']/a")).get(0).click();
		// Add the item to the Cart
		webDriver.findElement(By.id("button-cart")).click();	
				
		// Hover over the Cart
		Actions actions = new Actions(webDriver);
		// Explicit Wait until the Cart Button is available
		WebDriverWait wait = new WebDriverWait(webDriver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(mainAddToCartButton));
		actions.moveToElement(webDriver.findElement(mainAddToCartButton)).build().perform();
		// Explicit Wait until the 'View Cart' Button is available
		WebDriverWait wait2 = new WebDriverWait(webDriver, 5);
		wait2.until(ExpectedConditions.elementToBeClickable(miniCartButton));		
		actions.moveToElement(webDriver.findElement(miniCartButton)).click().build().perform();
		
		// Go to the Shopping Cart page
		webDriver.get("https://www.faishop.com/index.php?route=checkout/cart");
	}

	@Then("^verified selected \"([^\"]*)\" items are displayed on the Checkout page$")
	public void verified_selected_items_are_displayed_on_the_checkout_page(String itemName) throws Throwable {
		String transformedItemName = itemName.toLowerCase();
		System.out.println("Number of Frames: " + webDriver.findElements(By.tagName("iframe")).size());
		Assert.assertTrue(webDriver.findElement(By.xpath("(//table/tbody/tr/td[@class='text-left name']/a)[2]")).getText().toLowerCase().contains(transformedItemName));
	}
}
