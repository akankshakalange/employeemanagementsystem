package com.project.emp.SymboisisProject.model;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class ProjectManager {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int proid;
private String name;
private String email;
private Date dob;
private String gender;

private String mobno;
private String address;
private String password;
private String confpass;

public ProjectManager() {
	super();
	// TODO Auto-generated constructor stub
}




public ProjectManager(int proid, String name, String email, Date dob, String gender, String mobno, String address,
		String password, String confpass) {
	super();
	this.proid = proid;
	this.name = name;
	this.email = email;
	this.dob = dob;
	this.gender = gender;
	this.mobno = mobno;
	this.address = address;
	this.password = password;
	this.confpass = confpass;
	
}




public int getProid() {
	return proid;
}
public void setProid(int proid) {
	this.proid = proid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getMobno() {
	return mobno;
}
public void setMobno(String mobno) {
	this.mobno = mobno;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfpass() {
	return confpass;
}
public void setConfpass(String confpass) {
	this.confpass = confpass;
}








@Override
public String toString() {
	return "ProjectManager [proid=" + proid + ", name=" + name + ", email=" + email + ", dob=" + dob + ", gender="
			+ gender + ", mobno=" + mobno + ", address=" + address + ", password=" + password + ", confpass=" + confpass
			+ "]";
}






}
