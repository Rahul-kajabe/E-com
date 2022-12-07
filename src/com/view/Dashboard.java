package com.view;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.connection.JdbcConnection;

public class Dashboard extends JdbcConnection {

	static int product_id;
	static String productname;
	static int price;

	public static void showCategories()  {
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.err.println(
				"---------------------------------------------------------Product Categories------------------------------------------");

		try {
			ps = JdbcConnection.con
					.prepareStatement("select product_id, productname from accessories  order by product_id Asc");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			while (rs.next()) {

				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			Thread.currentThread();
			Thread.sleep(500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		try {
			chooseProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void chooseProduct() throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		sc = new Scanner(System.in);
		System.err.println(
				"---------------------------------------------------------Choose product-----------------------------------------------");
		 product_id = JdbcConnection.sc.nextInt();
		try {
			ps = JdbcConnection.con.prepareStatement(
					"select productname ,discription,price,quantity from accessories where product_id=?");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			ps.setInt(1, product_id);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			while (rs.next()) {

				productname = rs.getString(1);
				price = rs.getInt(3);
				System.out.println("Product name >>  " + productname);
				System.out.println("Description  >>  " + rs.getString(2));
				System.out.println("Price        >>  " +price);

				if (rs.getInt(4) > 0) {
					System.out.println("available    >>  " + "YES");
				} else {

					System.out.println("available    >>  " + "NO");
				}

				System.out.println("");
				System.out.println("");
				System.out.println("PRESS 1 to add this product to cart");
				System.out.println("PRESS 2 to view cart");
				System.out.println("PRESS 3 to view next product");
				System.out.println("PRESS 4 to exit");
				int i = sc.nextInt();
				OptionMenu.option(i);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
