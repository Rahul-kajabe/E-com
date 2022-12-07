package com.model;

public class User {

	private String customername;
	private String customermobno;
	private String customercity;
	private String email;
	private String password;
	private String confirmpassword;

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomermobno() {
		return customermobno;
	}

	public void setCustomermobno(String customermobno) {
		this.customermobno = customermobno;
	}

	public String getCustomercity() {
		return customercity;
	}

	public void setCustomercity(String customercity) {
		this.customercity = customercity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public User(String customername, String customermobno, String customercity, String email, String password,
			String confirmpassword) {
		this.customername = customername;
		this.customermobno = customermobno;
		this.customercity = customercity;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

}
