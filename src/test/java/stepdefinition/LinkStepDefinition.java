package stepdefinition;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import util.ChromeWebDriverUtility;

@RunWith(Cucumber.class)
public class LinkStepDefinition {
	public WebDriver webDriver;
	private List<WebElement> informationLinks;
	
	@Given("^User is on the faishop main page$")
	public void user_is_on_faishop_main_page() throws Throwable {
		webDriver = ChromeWebDriverUtility.getWebDriver("url");
	}
	
	@When("^User clicks the Information footer Links$")
	public void user_clicks_information_footer_links() throws Throwable {
		// Limiting the scope of the Footer Section (Information column)
		WebElement informationColumn = webDriver.findElement(By.xpath("//div[@id='footer']/div[2]/div[2]"));
		informationLinks = informationColumn.findElements(By.tagName("a"));
		
		for (int i = 0; i < informationLinks.size(); i++) {
			// Assign a Keyboard Event to open Links in a new Tab
			String clickFooterLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			informationLinks.get(i).sendKeys(clickFooterLink);
		}
	}
	
	@Then("^The footer Links are opened in a new Tab$")
	public void footer_links_are_opened_in_new_tab() throws Throwable {
		Set<String> windows = webDriver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		int windowsNumber = windows.size();
		int openedTabsNumber = informationLinks.size();
		
		System.out.println("Number of opened Tabs: " + windowsNumber);
		
		while (iterator.hasNext()) {
			webDriver.switchTo().window(iterator.next());
			System.out.println(webDriver.getTitle());
		}
		
		Assert.assertEquals(windowsNumber - 1, openedTabsNumber);
	}
}
