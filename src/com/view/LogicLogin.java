package com.view;

import java.sql.SQLException;

import com.dao.UserOperation;
import com.model.User;
import com.userdefineexception.UserDefinedException;


public class LogicLogin{
	
	static String userEmail;

	public static void getLogin(String email1 , String password1) throws UserDefinedException {
		//login
		
		UserOperation uoo = new UserOperation();
		User user = uoo.getUserCreadiential(email1, password1);
		
		if(user != null) {
			
			
			if ((password1.equals(user.getPassword()))) {

				System.out.println("You are successfully logged in");
				System.out.println();
				System.out.println("dashboard");
				
				userEmail = email1;
				
				} 
		}else {
			
			throw new UserDefinedException("You have entered an invalid username or password");
		}	
	}
	
	public static void getDashboard() {
		try {
			Dashboard.showCategories();
			Dashboard.chooseProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
