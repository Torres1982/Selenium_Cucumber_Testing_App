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
	
	@After("@SeleniumTest")
	public void webAfterActionSeleniumTest() {
		webDriver.close();
		System.out.println("*************** Closing Web After Hook Selenium Test");
	}
}
