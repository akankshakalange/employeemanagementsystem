package com.project.emp.SymboisisProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.emp.SymboisisProject.model.Employee;
import com.project.emp.SymboisisProject.model.Project;
import com.project.emp.SymboisisProject.repository.EmployeeRepository;
import com.project.emp.SymboisisProject.repository.ProjectRepository;
@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository prorepo;
	@Autowired
	private EmployeeRepository emprepo;
	@Override
	public Project addProject(Project pro) {
		
		return prorepo.save(pro);
	}

	@Override
	public void deleteProject(int id) {
		prorepo.deleteById(id);
		
	}

	@Override
	public List<Project> displayProject() {
		List<Project> list=prorepo.findAll();
		return list;
	}

	@Override
	public Project updateProject(Project pro) {
		
		return prorepo.save(pro);
	}

	@Override
	public Project progetbyid(int id) {
		Optional<Project> findbyid=prorepo.findById(id);
		Project pro=findbyid.get();
		return pro;
		
	}

	

	
}
