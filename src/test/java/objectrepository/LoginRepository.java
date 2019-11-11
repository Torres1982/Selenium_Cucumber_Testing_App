package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Use Page Object Factory
public class LoginRepository {
	WebDriver webDriver;
	@FindBy(id="input-email")
	WebElement email;
	@FindBy(id="input-password")
	WebElement password;
	@FindBy(css="input[value='Login']")
	WebElement loginButton;
	
	public LoginRepository(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public WebElement getEmailInputElement() {
		return email;
	}
	
	public WebElement getPasswordInputElement() {
		return password;
	}
	
	public WebElement getLoginButtonElement() {
		return loginButton;
	}
}
