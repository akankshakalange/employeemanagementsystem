package com.project.emp.SymboisisProject.model;

public class ProjectManagerLog {
	private String email;
	private String password;
	public ProjectManagerLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectManagerLog(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ProjectManagerLog [email=" + email + ", password=" + password + "]";
	}
	
}
