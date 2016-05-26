package com.luojuan.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static String driver ="com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/juan";
	private static String user = "root";
	private static String password = "xuetao";
	public static Connection getConn() throws Exception{
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
		
		
	}
   
}
