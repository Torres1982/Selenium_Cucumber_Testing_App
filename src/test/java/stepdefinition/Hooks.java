package stepdefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	@Before("@WebTest")
	public void webBeforeAction() {
		System.out.println("***** Web Before Hook *****");
	}
	
	@After("@WebTest")
	public void webAfterActionTest() {
		System.out.println("***** Web After Hook *****");
	}
}
