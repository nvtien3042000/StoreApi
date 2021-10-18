package com.StoreApp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
	
	private static Connection connection;
	
	public static Connection getConnection() {
		if(connection == null) {
			// driver
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
//				Properties props = DBProvider.getProperties();
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "nguyenvantien9");
//				connection = DriverManager.getConnection(props.getProperty("URL")
//														, props.getProperty("USER")
//														, props.getProperty("PASSWORD"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
}

