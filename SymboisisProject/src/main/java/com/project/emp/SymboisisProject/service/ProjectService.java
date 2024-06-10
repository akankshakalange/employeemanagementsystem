package com.project.emp.SymboisisProject.service;

import java.util.List;

import com.project.emp.SymboisisProject.model.Project;

public interface ProjectService {
public Project addProject(Project pro);
public void deleteProject(int id);
public List<Project> displayProject();
public Project updateProject(Project pro);
public Project progetbyid(int id);


}
