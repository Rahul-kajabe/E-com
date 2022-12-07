package com.view;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connection.JdbcConnection;




public class AddNewProduct {
	
	public static void addProduct() throws SQLException  {
		PreparedStatement ps = null;
		@SuppressWarnings("unused")
		Connection con = JdbcConnection.getConnectivity();
		try {
			ps = JdbcConnection.con.prepareStatement("insert into accessories(productname,discription,price,quantity) values(?,?,?,?)");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		while (true) {

			
			System.out.println("Enter productname");
			String productname = JdbcConnection.sc.nextLine();
			System.out.println("Enter discription");
			String description =JdbcConnection.sc.nextLine();
			System.out.println("Enter price");
			int price =JdbcConnection.sc.nextInt();
			System.out.println("Enter quantity");
			int quantity =JdbcConnection.sc.nextInt();
			try {
				ps.setString(1, productname);
				ps.setString(2, description);
				ps.setInt(3, price);
				ps.setInt(4, quantity);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Product added successfully");
			System.out.println("Press 'Y' to add another product");
			
			String s = JdbcConnection.sc.next();
			JdbcConnection.sc.nextLine();

			if (!(s.equalsIgnoreCase("Y"))) {
				break;

			}

		}
	}

}
