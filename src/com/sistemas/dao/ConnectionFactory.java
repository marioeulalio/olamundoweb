package com.sistemas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection(){
		String url = "jdbc:mysql://localhost/agenda";
		String user = "root";
		String pass = "1234";
		try {
			return DriverManager.getConnection(url,user,pass);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
