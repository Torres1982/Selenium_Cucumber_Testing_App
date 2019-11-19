package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutRepository {
	WebDriver webDriver;
	@FindBy(css="#content h1")
	private WebElement logoutHeaderText;
	
	public LogoutRepository(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public WebElement getLogoutHeaderText() { return logoutHeaderText; }
}
