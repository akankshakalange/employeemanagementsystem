package com.project.emp.SymboisisProject.model;

public class EmployeeLog {
private String email;
private String password;
public EmployeeLog(String email, String password) {
	super();
	this.email = email;
	this.password = password;
}
public EmployeeLog() {
	super();
	// TODO Auto-generated constructor stub
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
	return "EmployeeLog [email=" + email + ", password=" + password + "]";
}

}
