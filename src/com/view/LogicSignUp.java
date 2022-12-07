package com.view;

import java.sql.SQLException;

import com.dao.UserOperation;
import com.userdefineexception.UserDefinedException;


public class LogicSignUp{
	
	public static void getSignup(String customername,  long customermobno, String customercity, String email, String password
			,String confirmpassword) throws UserDefinedException {
		// sign up
		UserOperation uo = new UserOperation();
		if (((customername != null) && (!customername.equals(""))&&
				(customername.matches("^[a-zA-Z]*$") && (password.equals(confirmpassword))))) {
			
			try {
				uo.getUser(email, customermobno, customername, customercity, confirmpassword, confirmpassword);
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (UserDefinedException e) {
				e.printStackTrace();
			}
			
			System.out.println("User Registration  Successful! Please Login.");
		}else {
			
			throw new UserDefinedException("Something went wrong. User Registration failed....!");
		}
	}

	

}