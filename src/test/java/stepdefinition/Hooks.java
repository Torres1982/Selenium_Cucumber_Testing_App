package stepdefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.ChromeWebDriverUtility;

public class Hooks extends ChromeWebDriverUtility {	
	@Before("@WebTest")
	public void webBeforeAction() {
		System.out.println("***** Web Before Hook *****");
	}
	
	@After("@WebTest")
	public void webAfterActionTest() {
		System.out.println("***** Web After Hook *****");
	}
	
	@Before("@SeleniumTest")
	public void beforeActionSeleniumTest() {
		System.out.println("*************** Opening Before Hook - Selenium Test");
	}
	
	@After("@SeleniumTest")
	public void webAfterActionSeleniumTest() {
		webDriver.close();
		webDriver.quit();
		webDriver = null;
		System.out.println("*************** Closing Web After Hook - Selenium Test");
	}
}
