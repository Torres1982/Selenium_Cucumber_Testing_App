package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtility {
	public static WebDriver webDriver;
	public static Properties properties;
	
	// Create a WebDriver Utility class to be shared among all Step Definition Scenarios
	public static WebDriver getWebDriver() throws IOException {
		properties = new Properties();
		FileInputStream inputStreamFile = new FileInputStream("D:\\Program Files\\Eclipse Projects\\BDD_Testing_Cucumber\\src\\test\\java\\global.properties");
		properties.load(inputStreamFile);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AR20068603\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.get(properties.getProperty("url"));
		
		return webDriver;
	}
}
