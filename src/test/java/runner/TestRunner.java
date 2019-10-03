package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
				 glue = "stepdefinition",
				 tags = "@SmokeTest, @WebTest, @MobileTest, @RegistrationTest",
				 plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "junit:target/cucumber.html"})
public class TestRunner {

}
