package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcConnection {

	public static Connection con;
	public static Scanner sc = new Scanner(System.in);
 public static Connection getConnectivity() throws SQLException  {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce" , "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
		
		//added new space
	
	}
}
