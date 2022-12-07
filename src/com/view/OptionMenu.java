package com.view;



import com.connection.JdbcConnection;


public class OptionMenu{
	public static void option(int i) 
	{
		
		try {
			switch(i) {
			
			  case 1:  try {
					Cart.addToCart();
				} catch (Exception e) {
					e.printStackTrace();
				}
			  break;
			  case 2: Cart.goTOCart();
			  break;
			 case 3: Dashboard.chooseProduct();
			        break;
			 default : JdbcConnection.con.close();
			 			JdbcConnection.sc.close();
				 System.err.println("THANK FOR SHOPING");
			        	System.exit(0);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
