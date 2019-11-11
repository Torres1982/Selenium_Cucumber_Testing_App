package objectrepository;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Use Page Object Factory
public class RegistrationRepository {
	WebDriver webDriver;
	private List<String> inputFields;
	@FindBy(css="h1.heading-title")
	private WebElement registrationHeaderText;
	@FindBy(id="input-country")
	private WebElement country;
	By selectedRegionOption = By.xpath("//select[@id='input-zone']/option[@value='2641']");
	@FindBy(id="input-zone")
	private WebElement zone;
	@FindBy(xpath="//input[@type='radio' and @name='newsletter']")
	private List<WebElement> radioButtons;
	@FindBy(name="agree")
	private WebElement agreeCheckBox;
	@FindBy(css="input[type='checkbox']")
	private List<WebElement> checkBoxes;
	@FindBy(css="div[class='pull-right'] input[type='submit']")
	private WebElement registrationButton;
	
	public RegistrationRepository(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public WebElement getRegistrationHeaderText() {
		return registrationHeaderText;
	}
	
	public WebElement getCountry() {
		return country;
	}
	
	public By getSelectedRegionOption() {
		return selectedRegionOption;
	}
	
	public WebElement getZone() {
		return zone;
	}
	
	public List<WebElement> getRadioButtons() {
		return radioButtons;
	}
	
	public WebElement getAgreeCheckBox() {
		return agreeCheckBox;
	}
	
	public List<WebElement> getCheckBoxes() {
		return checkBoxes;
	}
	
	public WebElement getRegistrationButton() {
		return registrationButton;
	}
	
	public List<String> getRegistrationInputFieldSelectors() {
    	// Fill in the Registration Form
    	inputFields = Arrays.asList("#input-firstname", "#input-lastname", "#input-email", "#input-telephone", "#input-address-1",
    											 "#input-custom-field3", "#input-city", "#input-password", "#input-confirm");
    	return inputFields;
	}
}
