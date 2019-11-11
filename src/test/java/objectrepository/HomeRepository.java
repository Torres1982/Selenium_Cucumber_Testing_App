package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Use the Simple Page Object
public class HomeRepository {
	WebDriver webDriver;
	By loginLink = By.xpath("//div[@class='links']/ul/li[1]/a/span");
	By registrationLink = By.xpath("//div[@class='links']/ul/li[2]/a");
	
	public HomeRepository(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public WebElement getLoginLinkElement() {
		return webDriver.findElement(loginLink);
	}
	
	public WebElement getRegistrationLinkElement() {
		return webDriver.findElement(registrationLink);
	}
}
