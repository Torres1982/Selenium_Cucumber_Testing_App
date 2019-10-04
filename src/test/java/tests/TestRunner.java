package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
				 glue = "stepdefinition",
				 //tags = "@SmokeTest, @WebTest, @MobileTest, @RegistrationTest",
				 tags = "@SeleniumTest",
				 monochrome = true, // Neath Console Logging
				 strict = true, // Displays X Red Box in failed Test Cases
				 plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "junit:target/cucumber.html"})
public class TestRunner {

}
