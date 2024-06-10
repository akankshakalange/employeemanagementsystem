package com.project.emp.SymboisisProject.model;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int empid;
private String name;
private String email;
private Date dob;
private String gender;
private String designation;

private String mobno;
private String address;
private String password;
private String confpass;

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}




public Employee(int empid, String name, String email, Date dob, String gender, String designation, String mobno,
		String address, String password, String confpass) {
	super();
	this.empid = empid;
	this.name = name;
	this.email = email;
	this.dob = dob;
	this.gender = gender;
	this.designation = designation;
	this.mobno = mobno;
	this.address = address;
	this.password = password;
	this.confpass = confpass;
	
}




public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
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
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	designation = designation;
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
	return "Employee [empid=" + empid + ", name=" + name + ", email=" + email + ", dob=" + dob + ", gender=" + gender
			+ ", designation=" + designation + ", mobno=" + mobno + ", address=" + address + ", password=" + password
			+ ", confpass=" + confpass + "]";
}






}
