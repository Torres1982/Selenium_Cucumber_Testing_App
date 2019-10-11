package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import util.ChromeWebDriverUtility;

import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Cucumber.class)
public class LoginStepDefinition {
	public WebDriver webDriver;
	
    @Given("^User is on the Home Page$")
    public void user_is_on_the_home_page() throws Throwable {
    	webDriver = ChromeWebDriverUtility.getWebDriver();
    }
    
    @When("^User logs in with a username \"([^\"]*)\" and passwrod \"([^\"]*)\"$")
    public void user_logs_in_with_a_username_and_passwrod(String username, String password) throws Throwable {
    	System.out.println("User logged in with a Username: " + username + " and Password: " + password);
    }

    @Then("^User accesses their profile page$")
    public void user_accesses_their_profile_page() throws Throwable {
    	System.out.println("User accessed their Profile Page");
    }

    @And("^User can access all personal details: \"([^\"]*)\"$")
    public void user_can_access_all_personal_details(String access) throws Throwable {
    	System.out.println("User can access all Personal Details: " + access + "\n");
    }
    
    @When("^User register with following details$")
    public void user_register_with_following_details(DataTable dataTable) throws Throwable {
    	List<List<String>> list = dataTable.raw();
    	
    	System.out.println("User tries to Register with the following details:");					
    	
    	for (int i = 0; i < list.size(); i++) {
			System.out.println("Name: " + list.get(i).get(0) +
								"\nLast Name: " + list.get(i).get(1) +
								"\nEmail: " + list.get(i).get(2) +
								"\nTelephone: " + list.get(i).get(3) +
								"\nAddress: " + list.get(i).get(4) +
								"\nPhone 2: " + list.get(i).get(5) +
								"\nCity: " + list.get(i).get(6) +
								"\nPassword: " + list.get(i).get(7) +
								"\nConfirmed: " + list.get(i).get(8));
    	}
    	
    	// Navigate to Registration page
    	webDriver.findElement(By.xpath("//div[@class='links']/ul/li[2]/a")).click();
    	
    	// Confirm the Registration page is loaded
    	Assert.assertTrue(webDriver.findElement(By.cssSelector("h1.heading-title")).getText().contains("Register"));
    	
    	// Fill in the Registration Form
    	webDriver.findElement(By.cssSelector("#input-firstname")).sendKeys(list.get(0).get(0));
    	webDriver.findElement(By.cssSelector("#input-lastname")).sendKeys(list.get(0).get(1));
    	webDriver.findElement(By.cssSelector("#input-email")).sendKeys(list.get(0).get(2));
    	webDriver.findElement(By.cssSelector("#input-telephone")).sendKeys(list.get(0).get(3));
    	webDriver.findElement(By.cssSelector("#input-address-1")).sendKeys(list.get(0).get(4));
    	webDriver.findElement(By.cssSelector("#input-custom-field3")).sendKeys(list.get(0).get(5));
    	webDriver.findElement(By.cssSelector("#input-city")).sendKeys(list.get(0).get(6));
    	webDriver.findElement(By.cssSelector("#input-password")).sendKeys(list.get(0).get(7));
    	webDriver.findElement(By.cssSelector("#input-confirm")).sendKeys(list.get(0).get(8));
    	
    	// Select Country and County from the Drop-down Box
    	String country = "Poland";
    	Select selectCountry = new Select(webDriver.findElement(By.id("input-country")));
    	selectCountry.selectByVisibleText(country);
    	Assert.assertEquals(selectCountry.getFirstSelectedOption().getText(), country);
    	
    	//WebDriverWait wait = new WebDriverWait(webDriver, 2);
    	//wait.until(ExpectedConditions.elementToBeClickable(By.id("input-zone")));
    	//wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.id("input-zone"))));
    	Thread.sleep(2000);
    	
    	String region = "Pomorskie";
    	Select selectState = new Select(webDriver.findElement(By.id("input-zone")));
    	selectState.selectByVisibleText(region);
    	Assert.assertEquals(selectState.getOptions().get(11).getText(), region);
    	//selectState.selectByIndex(11);
    	
    	// Handle the Check Box
    	WebElement termsAgreeCheckBox = webDriver.findElement(By.name("agree"));
    	Assert.assertFalse(termsAgreeCheckBox.isSelected());
    	termsAgreeCheckBox.click();
    	Assert.assertTrue(termsAgreeCheckBox.isSelected());
    	
    	// Find the number of Check Boxes and Radio Buttons on the site
    	System.out.println("Number of Radio Buttons: " + webDriver.findElements(By.cssSelector("input[type='radio']")).size());
    	System.out.println("Number of Checkboxes: " + webDriver.findElements(By.cssSelector("input[type='checkbox']")).size());
    }
    
    @When("^User logs in with a username (.+) and password (.+)$")
    public void user_logs_in_with_following_username_and_password(String username, String password) throws Throwable {
    	System.out.println("Username: " + username + ", Password: " + password);
    }
    
    @Given("^User is not registered$")
    public void user_is_not_registered() throws Throwable {
    	System.out.println("User is not registered in the system");
    }
    
    @When("^User click the Registration Button$")
    public void user_click_the_Registration_Button() throws Throwable {
    	System.out.println("User clicked the Registration Button");
    }

    @Then("^The Error Message is displayed$")
    public void the_Error_Message_is_displayed() throws Throwable {
    	System.out.println("Registration Error Message is displayed");
    }

    @Then("^User is redirected to the login page$")
    public void user_is_redirected_to_the_login_page() throws Throwable {
    	System.out.println("User is redirected to the Login Page");
    }
}
