package com.view;

import java.sql.Connection;
import java.sql.SQLException;

import com.connection.JdbcConnection;
import com.userdefineexception.UserDefinedException;

public class LogicAdmin {

	static String username = "admin@123";
	static String password = "pass@123";

	public static void getAdmin(String uname, String pass) throws UserDefinedException  {

		if ((username.equals(uname)) && (pass.equals(password))) {

			System.out.println("You are successfully logged in");
			System.out.println();
			System.out.println("dashboard");
		} else {
			throw new UserDefinedException("You have entered an invalid username or password");
		}
	}

	public static void getAdminOperation() {
		int num;
		try {
			@SuppressWarnings("unused")
			Connection con = JdbcConnection.getConnectivity();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("press 1 for  Add Product ");
		System.out.println("Press 2 for Remove Product");
		num = JdbcConnection.sc.nextInt();
		JdbcConnection.sc.nextLine();
		switch (num) {
		case 1:
			try {
				AddNewProduct.addProduct();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		case 2:
			RemoveProduct.remove();
		}
	}
}
