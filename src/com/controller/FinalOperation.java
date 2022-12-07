package com.controller;

import java.sql.SQLException;
import java.util.Scanner;
import com.dao.UserOperation;
import com.userdefineexception.UserDefinedException;
import com.view.LogicAdmin;
import com.view.LogicLogin;
import com.view.LogicSignUp;

public class FinalOperation {

	public void getFinalOperation() throws UserDefinedException, SQLException {
		@SuppressWarnings("unused")
		UserOperation uo = new UserOperation();
		Scanner sc = new Scanner(System.in);
		System.err.println("---------------------------------------------------------Welcome to Online shop---------------------------------------------");
		System.out.println("please enter 1 signup");
		System.out.println("please enter 2 login");
		System.out.println("please enter 3 admin");
		int num = sc.nextInt();
		switch(num) {
		case 1:
			//sing up
		System.out.println("enter sign up details");
		System.out.println();
		System.out.println("full name"); String customername =sc.next(); 
		System.out.println("mobile number"); long  customermobno =sc.nextLong(); 
		System.out.println("city"); String customercity = sc.next();
		System.out.println("username or email"); String  email =sc.next(); 
		System.out.println("password"); String password =sc.next();
		System.out.println("Confirm password"); String confirmpassword = sc.next(); 
		LogicSignUp.getSignup(customername, customermobno, customercity, email, password, confirmpassword);
		case 2:
			//login
			System.out.println("enter login details");
			System.out.println();
			System.out.println("username or email"); String email1 = sc.next();
			System.out.println("password");  String password1 =sc.next();
			LogicLogin.getLogin(email1, password1);
			LogicLogin.getDashboard();
			break;
			
		case 3:
			//adminlogin
			System.out.println("enter Admin Login details");
			System.out.println();
			System.out.println("username or email"); String uname = sc.next();
			System.out.println("password");String pass =sc.next();
			LogicAdmin.getAdmin(uname , pass );
			LogicAdmin.getAdminOperation();
		}
		sc.close();
	}
}
