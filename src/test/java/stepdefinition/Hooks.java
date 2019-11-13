package stepdefinition;

import java.sql.SQLException;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.ChromeWebDriverUtility;
import util.JdbcConnection;

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
	public void webAfterActionSeleniumTest() throws SQLException {
		webDriver.close();
		webDriver.quit();
		webDriver = null;
		JdbcConnection.closeConnections();
		System.out.println("*************** Closing Web After Hook - Selenium Test");
	}
}
