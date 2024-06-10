package com.project.emp.SymboisisProject.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int projectId;
private String proname;
private String clientName;
private String projectManager;
private String projectEmployee;
private String devPlatform;
private String databasetech;
private String prodescription;

public Project() {
	super();
	// TODO Auto-generated constructor stub
}



public Project(int projectId, String proname, String clientName, String projectManager, String projectEmployee,
		String devPlatform, String databasetech, String prodescription) {
	super();
	this.projectId = projectId;
	this.proname = proname;
	this.clientName = clientName;
	this.projectManager = projectManager;
	this.projectEmployee = projectEmployee;
	this.devPlatform = devPlatform;
	this.databasetech = databasetech;
	this.prodescription = prodescription;
	
}



public int getProjectId() {
	return projectId;
}
public void setProjectId(int projectId) {
	this.projectId = projectId;
}
public String getProname() {
	return proname;
}
public void setProname(String proname) {
	this.proname = proname;
}
public String getClientName() {
	return clientName;
}
public void setClientName(String clientName) {
	this.clientName = clientName;
}
public String getProjectManager() {
	return projectManager;
}
public void setProjectManager(String projectManager) {
	this.projectManager = projectManager;
}
public String getProjectEmployee() {
	return projectEmployee;
}
public void setProjectEmployee(String projectEmployee) {
	this.projectEmployee = projectEmployee;
}
public String getDevPlatform() {
	return devPlatform;
}
public void setDevPlatform(String devPlatform) {
	this.devPlatform = devPlatform;
}
public String getDatabasetech() {
	return databasetech;
}
public void setDatabasetech(String databasetech) {
	this.databasetech = databasetech;
}
public String getProdescription() {
	return prodescription;
}
public void setProdescription(String prodescription) {
	this.prodescription = prodescription;
}



@Override
public String toString() {
	return "Project [projectId=" + projectId + ", proname=" + proname + ", clientName=" + clientName
			+ ", projectManager=" + projectManager + ", projectEmployee=" + projectEmployee + ", devPlatform="
			+ devPlatform + ", databasetech=" + databasetech + ", prodescription=" + prodescription + "]";
}









}
