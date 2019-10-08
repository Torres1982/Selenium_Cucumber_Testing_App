package stepdefinition;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.WebDriverUtility;

public class Hooks {
	public WebDriver webDriver;
	
	@Before("@WebTest")
	public void webBeforeAction() {
		System.out.println("***** Web Before Hook *****");
	}
	
	@After("@WebTest")
	public void webAfterActionTest() {
		System.out.println("***** Web After Hook *****");
	}
	
//	@After("@SeleniumTest")
//	public void webAfterActionSeleniumTest() {
//		webDriver = WebDriverUtility.getWebDriver();
//		webDriver.close();
//		System.out.println("***** Closing Web After Hook Selenium Test *****");
//	}
}
