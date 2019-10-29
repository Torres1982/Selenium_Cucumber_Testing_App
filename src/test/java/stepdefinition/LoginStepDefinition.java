package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.DataTable;
import cucumber.api.junit.Cucumber;
import util.ChromeWebDriverUtility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
    	webDriver = ChromeWebDriverUtility.getWebDriver("url");
    }
    
    // Login with usage of Parameterisation
    @When("^User logs in with a username (.+) and password (.+)$")
    public void user_logs_in_with_username_and_password(String email, String password) throws Throwable {
    	System.out.println("Username: " + email + ", Password: " + password);
    	// Click the Login link
    	webDriver.findElement(By.xpath("//div[@class='links']/ul/li[1]/a/span")).click();  	
    	// Type the email
    	webDriver.findElement(By.id("input-email")).sendKeys(email);
    	// Type the password
    	webDriver.findElement(By.id("input-password")).sendKeys(password);
    	// Click the Login button
    	webDriver.findElement(By.cssSelector("input[value='Login']")).click();
    }
    
    // Login with usage of Data Driven from the Excel file
    @When("^User logs in with credentials retrieved from the Excel file$")
    public void user_logs_in_with_credentials_retrieved_from_excel_file() throws IOException {
    	// All Data retrieved from the Excel file will be stored in this Array
    	ArrayList<String> loginDataArrayList = util.ExcelTestDataDriven.getExcelData("Login");
   	
    	// Click the Login link
    	webDriver.findElement(By.xpath("//div[@class='links']/ul/li[1]/a/span")).click();  	
    	// Type the email
    	webDriver.findElement(By.id("input-email")).sendKeys(loginDataArrayList.get(1));
    	// Type the password
    	webDriver.findElement(By.id("input-password")).sendKeys(loginDataArrayList.get(2));
    	// Click the Login button
    	webDriver.findElement(By.cssSelector("input[value='Login']")).click();
    }

    @Then("^User accesses their profile page$")
    public void user_accesses_their_profile_page() throws Throwable {
    	Assert.assertTrue(webDriver.findElement(By.xpath("//span[contains(text(), 'Logout') and @class='top-menu-link']")).getText().contains("Logout"));
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
    	List<String> inputFields = Arrays.asList("#input-firstname", "#input-lastname", "#input-email", "#input-telephone", "#input-address-1",
    											 "#input-custom-field3", "#input-city", "#input-password", "#input-confirm");
    	
    	for (int i = 0; i < inputFields.size(); i++) {
    		webDriver.findElement(By.cssSelector(inputFields.get(i))).sendKeys(list.get(0).get(i));
    	}
    	
    	// Confirm that Passwords match
    	String password = webDriver.findElement(By.cssSelector(inputFields.get(7))).getText();
    	String confirm = webDriver.findElement(By.cssSelector(inputFields.get(8))).getText();
    	
    	Assert.assertTrue(password.equals(confirm));
    	
    	// Select Country and County from the Drop-down Box
    	String country = "Poland";
    	Select selectCountry = new Select(webDriver.findElement(By.id("input-country")));
    	selectCountry.selectByVisibleText(country);
    	Assert.assertEquals(selectCountry.getFirstSelectedOption().getText(), country);
    	
    	// EXPLICIT WAIT applied - targets only the specific Element (second Drop-Down List)
    	// Wait before the Region dynamic Drop-Down List is loaded and populated with Strings
    	WebDriverWait wait = new WebDriverWait(webDriver, 2);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='input-zone']/option[@value='2641']")));
    	
    	String region = "Pomorskie";
    	Select selectState = new Select(webDriver.findElement(By.id("input-zone")));    	
    	selectState.selectByVisibleText(region);
    	Assert.assertEquals(selectState.getOptions().get(11).getText(), region);
    	//selectState.selectByIndex(11);
    	    	
    	// Handle Radio Buttons
    	List<WebElement> radioButons = webDriver.findElements(By.xpath("//input[@type='radio' and @name='newsletter']"));
    	
    	// check if Radio Buttons exists on the page
    	if (radioButons.size() == 2) {
    		int counter = 1;
    		
    		for (int i = 0; i < radioButons.size(); i++) {
    			Assert.assertTrue(radioButons.get(i).isDisplayed());
    			
    			// Verify that both Radio Buttons are not selected
    			if (radioButons.get(i).isSelected()) {
        			Assert.assertFalse(radioButons.get(counter).isSelected());
        			radioButons.get(counter).click();
        			Assert.assertTrue(radioButons.get(counter).isSelected());
    			}
    			counter--;
    		}
    	}
    	
    	// Handle the Check Box
    	WebElement termsAgreeCheckBox = webDriver.findElement(By.name("agree"));
    	Assert.assertFalse(termsAgreeCheckBox.isSelected());
    	termsAgreeCheckBox.click();
    	Assert.assertTrue(termsAgreeCheckBox.isSelected());
    	
    	// Find the number of Check Boxes and Radio Buttons on the site
    	System.out.println("Number of Radio Buttons: " + radioButons.size());
    	System.out.println("Number of Checkboxes: " + webDriver.findElements(By.cssSelector("input[type='checkbox']")).size());
    	
    	// Submit and Register
    	webDriver.findElement(By.cssSelector("div[class='pull-right'] input[type='submit']")).click();
    }
}
