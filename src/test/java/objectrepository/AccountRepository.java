package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRepository {
	WebDriver webDriver;
	@FindBy(xpath="//span[contains(text(), 'Logout')]")
	WebElement logoutButton;
	
	public AccountRepository(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public WebElement getLogoutButtonElement() {
		return logoutButton;
	}
}
