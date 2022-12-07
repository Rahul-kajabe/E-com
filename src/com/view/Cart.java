package com.view;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.connection.JdbcConnection;
public class Cart {


	public static void option(int i) throws SQLException {
		
		switch (i) {

		case 1:
			Dashboard.showCategories();
			
			break;
		default :
			JdbcConnection.con.close();
			JdbcConnection.sc.close();
			System.err.println("THANKS FOR SHOPPING");
			System.exit(0);
		
		}

	}
	  public static void addToCart() throws Exception {
	  
	  
	  @SuppressWarnings("unused")
	Statement st =JdbcConnection.con.createStatement();
	  
	  
	  PreparedStatement ps;
	  System.out.println("Enter product quantity to be added in cart");
	  int quantity = JdbcConnection.sc.nextInt();
	  ps=JdbcConnection.con.prepareStatement("insert into cart(email,product_id, productname,quantity,price) values (?,?,?,?,?) ");
	  ps.setString(1,LogicLogin.userEmail); 
	  ps.setInt(2,Dashboard.product_id);
	  ps.setString(3,Dashboard.productname); 
	  ps.setInt(4,quantity);
	  ps.setInt(5, Dashboard.price);
	  
	  int i= ps.executeUpdate();
	  
	  if(i>0) {
	  
	  System.out.println("Product added to cart successfully");
	  
	  
	  }
	  System.out.println("press 1 to view cart");
	  System.out.println("press 2 to view product");
	  System.out.println("press 3 to logout");
	  int j = JdbcConnection.sc.nextInt();
	  
	  switch(j) {
	  
	  case 1 :
		  Cart.goTOCart();
		  break;
	  case 2 :
		  Dashboard.showCategories();
		  
		default :
			JdbcConnection.con.close();
			JdbcConnection.sc.close();
			System.err.println("THANK FOR SHOPING");
			System.exit(0);
	  }
	  
	  }

	public static void goTOCart() throws SQLException {
		int price = 0;
		int totalQuantity = 0;
		ResultSet rs = null;
		PreparedStatement ps = null;

		System.err.println("-------------------------------------------------Products in cart------------------------------------");

		try {
			ps = JdbcConnection.con.prepareStatement("select productname,quantity,price from cart where email = ?");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		ps.setString(1,LogicLogin.userEmail);
		
		
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			while (rs.next()) {

				int i = rs.getInt(2);
				int temp = rs.getInt(3);
				System.out.println("Product name >>  " + rs.getString(1));
				System.out.println("Quantity     >>  " + i);
				System.out.println("Price        >>  " + temp);

				price = temp*i + price;
				
				totalQuantity = totalQuantity + i;

				System.out.println("");

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println("");
		System.out.println("");
		System.out.println("Total number of products in cart >> " + totalQuantity);
		System.out.println("Take your bill receipt  >> " + price);

		System.out.println("PRESS 1 : To view product list ");
		System.out.println("PRESS 2 : To logout");

		int i = JdbcConnection.sc.nextInt();
		Cart.option(i);
	}

}
