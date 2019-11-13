package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	public static Properties getPropertiesValues(String fileName) throws IOException {		
		Properties properties = new Properties();
		String userPath = System.getProperty("user.dir") + "\\resources\\" + fileName;
		FileInputStream inputStreamFile = new FileInputStream(userPath);
		properties.load(inputStreamFile);
		
		return properties;
	}
}
