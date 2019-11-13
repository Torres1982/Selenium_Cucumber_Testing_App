package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcConnection {
	private static Properties properties;
	
	// Connection to DB
	public static Connection getJdbcConnection() throws IOException, SQLException {
		properties = new Properties();
		String userPath = System.getProperty("user.dir") + "\\resources\\";
		FileInputStream inputStreamFile = new FileInputStream(userPath + "jdbc.properties");
		properties.load(inputStreamFile);
		String url = properties.getProperty("jdbcUrl");
		String user = properties.getProperty("jdbcUser");
		String password = properties.getProperty("jdbcPassword");
		
		return DriverManager.getConnection(url, user, password);
	}
	
	// Retrieve the Login Users' details
	public static ResultSet getLoginUsers() throws IOException, SQLException {
		Connection connection = getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet loginUsers = statement.executeQuery("SELECT * FROM login WHERE name='Artur';");
				
		return loginUsers;
	}
}
