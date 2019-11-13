package util;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.lang.String;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromeWebDriverUtility {
	public static WebDriver webDriver;
	public static Properties properties;
	
	// Create a WebDriver Utility class to be shared among all Step Definition Scenarios
	public static WebDriver getWebDriver() throws IOException {
		String userPath = System.getProperty("user.dir") + "\\resources\\";
		properties = PropertiesUtility.getPropertiesValues("global.properties");
		String browser = properties.getProperty("browser");
		// If you need to Send the browser name in maven console command
		//mvn test -Dbrowser=firefox
		//String browser = System.getProperty("browser");
		
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", userPath + "chromedriver.exe");
			webDriver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", userPath + "geckodriver.exe");
			webDriver = new FirefoxDriver();
		} else if (browser.equals("IE")) {
			// Add code for IE
		}
		
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.get(properties.getProperty("url"));
		System.out.println("*************** URL Verification: " + webDriver.getCurrentUrl());
		
		return webDriver;
	}
}
