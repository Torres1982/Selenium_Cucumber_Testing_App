package stepdefinition;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import objectrepository.HomeRepository;
import util.ChromeWebDriverUtility;

@RunWith(Cucumber.class)
public class LinkStepDefinition {
	public WebDriver webDriver;
	private List<WebElement> informationLinks;
	private static final Logger logger = LogManager.getLogger(LinkStepDefinition.class.getName());
	
	@Given("^User is on the faishop main page$")
	public void user_is_on_faishop_main_page() throws Throwable {
		webDriver = ChromeWebDriverUtility.getWebDriver("url");
	}
	
	@When("^User clicks the Information footer Links$")
	public void user_clicks_information_footer_links() throws Throwable {
		HomeRepository homeRepository = new HomeRepository(webDriver);
		// Limiting the scope of the Footer Section (Information column)
		logger.debug("Identifying clickable footer Links!");
		WebElement informationColumn = homeRepository.getColumnLinksElement();
		informationLinks = informationColumn.findElements(homeRepository.getInformationLinks());
		
		for (int i = 0; i < informationLinks.size(); i++) {
			// Assign a Keyboard Event to open Links in a new Tab
			String clickFooterLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			informationLinks.get(i).sendKeys(clickFooterLink);
			logger.info("Link " + informationLinks.get(i) + " clicked!");
		}
	}
	
	@Then("^The footer Links are opened in a new Tab$")
	public void footer_links_are_opened_in_new_tab() throws Throwable {
		Set<String> windows = webDriver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		int windowsNumber = windows.size();
		int openedTabsNumber = informationLinks.size();
		
		logger.debug("Number of opened Tabs: " + windowsNumber);
		
		while (iterator.hasNext()) {
			webDriver.switchTo().window(iterator.next());
			logger.info("New Tab: " + webDriver.getTitle());
		}
		
		Assert.assertEquals(windowsNumber - 1, openedTabsNumber);
	}
}
