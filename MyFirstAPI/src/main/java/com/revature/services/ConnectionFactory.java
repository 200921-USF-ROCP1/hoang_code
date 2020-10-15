package com.revature.services;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//The ConnectionFactory carries all of the information to construct new Connections,
//but does not manage them. Its up to the programmer to close the connections once they are done.
public class ConnectionFactory {
	/*static final String	connectionString = "jdbc:postgresql://lallah.db.elephantsql.com:5432/rwqjodug",
						username = "rwqjodug",
						password = "QYc9S2PnXaC6r8wQLgu2iAs-eJz_nFWF";*/
			
	public static Connection getConnection() {
		try {
			FileInputStream fis = new FileInputStream("connection.properties");
			Properties prop = new Properties();
			prop.load(fis);
			
			Connection connection = DriverManager.getConnection(
										prop.getProperty("url"), 
										prop.getProperty("username"), 
										prop.getProperty("password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConnection(Connection connection) {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
