package com.controller;

import java.sql.SQLException;

import com.connection.JdbcConnection;
import com.userdefineexception.UserDefinedException;

public class MainApplication {

	public static void main(String[] args) {
		FinalOperation finalOperation = new FinalOperation();
		try {
			finalOperation.getFinalOperation();
		} catch (UserDefinedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcConnection.sc.close();
			try {
				JdbcConnection.con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
