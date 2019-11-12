package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriverUtility {
	public static WebDriver webDriver;
	public static Properties properties;
	
	// Create a WebDriver Utility class to be shared among all Step Definition Scenarios
	public static WebDriver getWebDriver() throws IOException {
		properties = new Properties();
		FileInputStream inputStreamFile = new FileInputStream("D:\\Program Files\\Eclipse Projects\\BDD_Testing_Cucumber\\global.properties");
		properties.load(inputStreamFile);
		String browser = properties.getProperty("browser");
		
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\AR20068603\\chromedriver.exe");
			webDriver = new ChromeDriver();
		}
		
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.get(properties.getProperty("url"));
		System.out.println("*************** URL Verification: " + webDriver.getCurrentUrl());
		
		return webDriver;
	}
}
