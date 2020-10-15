package com.revature.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//A connectionservice provides centralized place to store your connection object
//now whenever one is needed, you can simply call ConnectionService.getConnection()
//Singleton class
//A singleton has only 1 instance (or zero in this case) and carries
//centralized data and functionality.
public class ConnectionService {
	private static Connection connection;
	static final String	connectionString = "jdbc:postgresql://lallah.db.elephantsql.com:5432/rwqjodug",
						username = "rwqjodug",
						password = "QYc9S2PnXaC6r8wQLgu2iAs-eJz_nFWF";
			
	public static Connection getConnection() {
		if(connection == null) {
			try {
				connection = DriverManager.getConnection(connectionString, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	public static void closeConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
