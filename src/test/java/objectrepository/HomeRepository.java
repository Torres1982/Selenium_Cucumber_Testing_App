package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Use Simple Page Object for Login and Registration
// Use Object Page Factory for Links
public class HomeRepository {
	WebDriver webDriver;
	// Handles Login and Registration Step Definitions
	private By loginLink = By.xpath("//div[@class='links']/ul/li[1]/a/span");
	private By registrationLink = By.xpath("//div[@class='links']/ul/li[2]/a");
	// Handles Link Step Definition
	@FindBy(xpath="//div[@id='footer']/div[2]/div[2]")
	private WebElement columnLinks;
	private By informationLinks = By.tagName("a");
	
	public HomeRepository(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public WebElement getLoginLinkElement() { return webDriver.findElement(loginLink); }
	public WebElement getRegistrationLinkElement() { return webDriver.findElement(registrationLink); }
	public WebElement getColumnLinksElement() { return columnLinks; }
	public By getInformationLinks() { return informationLinks; }
}
