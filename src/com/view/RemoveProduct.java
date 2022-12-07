package com.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connection.JdbcConnection;



public class RemoveProduct {
	
	Connection con = null;
  public static void remove() 
	{
		PreparedStatement ps=null;
	    try {
			ps=JdbcConnection.con.prepareStatement("delete from accessories where product_id=?");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    
        while(true) {
        System.out.println("Enter product id to remove the accessories ");
		int id= JdbcConnection.sc.nextInt();
		
		try {
			ps.setInt(1, id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Product removed successfully");
		System.out.println("Press 'Y' to remove another product");
		String s = JdbcConnection.sc.next();
		
		if(!(s.equalsIgnoreCase("Y"))) {
			break;
		}
        }
		
	}
}
