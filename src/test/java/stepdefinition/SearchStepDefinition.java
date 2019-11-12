package stepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import objectrepository.SearchRepository;
import util.ChromeWebDriverUtility;

@RunWith(Cucumber.class)
public class SearchStepDefinition extends ChromeWebDriverUtility {
	private final static Logger logger = LogManager.getLogger(SearchStepDefinition.class.getName());
	
	@Given("^User is on the online shop landing page$")
	public void user_is_on_football_shop_online_main_page() throws Throwable {
		webDriver = ChromeWebDriverUtility.getWebDriver();
	}
	
	@When("^User search for \"([^\"]*)\" items$")
	public void user_search_for_selected_items(String itemName) throws Throwable {
		SearchRepository searchRepository = new SearchRepository(webDriver);
		searchRepository.getSearchInputElement().sendKeys(itemName);
		logger.debug("User searched for " + itemName + " item!");		
	}
	
	@And("^\"([^\"]*)\" model results are displayed on the page$")
	public void model_results_are_displayed_on_page(String itemName) throws Throwable {
		SearchRepository searchRepository = new SearchRepository(webDriver);
		String transformedItemName = itemName.toLowerCase();
		webDriver.get(properties.getProperty("searchedItemResultsUrl"));
		Assert.assertTrue(searchRepository.getSearchedItemElements().get(0).getText().toLowerCase().contains(transformedItemName));
		logger.info(itemName + " items are displayed on the page!");
	}

	@And("^User proceeded to the Checkout page to buy the items$")
	public void user_proceeded_to_the_checkout_page_to_buy_the_items() throws Throwable {
		SearchRepository searchRepository = new SearchRepository(webDriver);
		searchRepository.getSearchedItemElements().get(0).click();
		logger.debug("User cliks the item link!");
		// Add the item to the Cart
		searchRepository.getAddToCartButtonElement().click();
		logger.debug("User clicks the cart button to add the item to a Shopping Cart!");
				
		// Hover over the Cart
		Actions actions = new Actions(webDriver);
		
		// Explicit Wait until the Cart Button is available
		WebDriverWait wait = new WebDriverWait(webDriver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(searchRepository.getMainCartButtonBy()));
		actions.moveToElement(searchRepository.getMainCartButtonElement()).build().perform();
		logger.debug("User moves to a Cart Button element!");
		
		// Explicit Wait until the 'View Cart' Button is available
		WebDriverWait wait2 = new WebDriverWait(webDriver, 5);
		wait2.until(ExpectedConditions.elementToBeClickable(searchRepository.getMiniCartButtonBy()));		
		actions.moveToElement(searchRepository.getMiniCartButtonElement()).click().build().perform();
		logger.debug("User clisks the link to process to a Shopping Cart page!");
		
		// Go to the Shopping Cart page
		webDriver.get(properties.getProperty("shoppingCartPageUrl"));
	}

	@Then("^verified selected \"([^\"]*)\" items are displayed on the Checkout page$")
	public void verified_selected_items_are_displayed_on_the_checkout_page(String itemName) throws Throwable {
		SearchRepository searchRepository = new SearchRepository(webDriver);
		logger.info("User navigates to a Shopping Cart page!");
		String transformedItemName = itemName.toLowerCase();
		System.out.println("Number of Frames: " + searchRepository.getIframesElements().size());
		Assert.assertTrue(searchRepository.getDisplayedItemName().getText().toLowerCase().contains(transformedItemName));
	}
}
