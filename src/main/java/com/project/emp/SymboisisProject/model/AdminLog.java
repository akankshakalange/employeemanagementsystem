package com.project.emp.SymboisisProject.model;

public class AdminLog {
	private String Username;
	private String password;
	public AdminLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminLog(String username, String password) {
		super();
		Username = username;
		this.password = password;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminLog [Username=" + Username + ", password=" + password + "]";
	}
	

}
