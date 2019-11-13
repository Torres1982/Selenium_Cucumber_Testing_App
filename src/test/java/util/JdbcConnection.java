package util;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.logging.log4j.*;

import stepdefinition.LoginStepDefinition;

public class JdbcConnection {
	private static final Logger logger = LogManager.getLogger(LoginStepDefinition.class.getName());
	private static Properties properties;
	private static ResultSet loginUsers;
	private static PreparedStatement statement;
	private static Connection connection;
	
	// Connection to DB
	public static Connection getJdbcConnection() throws IOException, SQLException {
		properties = PropertiesUtility.getPropertiesValues("jdbc.properties");
		String url = properties.getProperty("jdbcUrl");
		String user = properties.getProperty("jdbcUser");
		String password = properties.getProperty("jdbcPassword");
		
		return DriverManager.getConnection(url, user, password);
	}
	
	// Retrieve the Login Users' details
	public static ResultSet getLoginUsers() throws IOException, SQLException {
		connection = getJdbcConnection();
		String sql = "SELECT * FROM login WHERE name=?;";		
		statement = connection.prepareStatement(sql);
		statement.setString(1, "Artur");
		loginUsers = statement.executeQuery();
						
		return loginUsers;
	}
	
	// Close all Connections
	public static void closeConnections() throws SQLException {
		if (loginUsers != null) { loginUsers.close(); logger.info("ResultSet closed successfully!"); }
		if (statement != null) { statement.close(); logger.info("PreparedStatement closed successfully!"); }
		if (connection != null) { connection.close(); logger.info("JDBC Connection closed successfully!"); }
	}
}
