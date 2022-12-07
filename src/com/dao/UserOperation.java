package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.JdbcConnection;
import com.model.User;
import com.userdefineexception.UserDefinedException;
import com.view.LogicSignUp;

public class UserOperation extends LogicSignUp {
	Connection con = null;
	PreparedStatement ps = null;
	public void getUser(String email, long customermobno, String customername, String customercity,
			String confirmpassword, String password) throws SQLException, UserDefinedException {

		// signup
		con = JdbcConnection.getConnectivity();
		ps = con.prepareStatement("insert into usereg(customername,customermobno,customercity,email,password,confirmpassword) values(?,?,?,?,?,?)");
		ps.setString(1, customername);
		ps.setLong(2, customermobno);
		ps.setString(3, customercity);
		ps.setString(4, email);
		ps.setString(5, password);
		ps.setString(6, confirmpassword);
		ps.executeUpdate();
	}
	
	public  User getUserCreadiential(String email, String password) {
		//login
		User user = null;
		try {
			con = JdbcConnection.getConnectivity();
			ps = con.prepareStatement("select * from usereg where email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			if (rs.isBeforeFirst()) {
				rs.next();
			user = new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7));
				System.out.println(rs.getString(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public void getAdminLogic() throws SQLException {
	con = JdbcConnection.getConnectivity();
	
	}
}