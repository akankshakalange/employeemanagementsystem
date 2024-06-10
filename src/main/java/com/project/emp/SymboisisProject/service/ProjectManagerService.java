package com.project.emp.SymboisisProject.service;

import java.util.List;

import com.project.emp.SymboisisProject.model.Employee;
import com.project.emp.SymboisisProject.model.ProjectManager;

public interface ProjectManagerService {
public ProjectManager addProManager(ProjectManager pm);
public void deleteProManager(int id);
public List<ProjectManager> displayProManager();
public ProjectManager updateProManager(ProjectManager pm);
public ProjectManager getById(int id);
ProjectManager findByEmail(String email);
}
