package com.project.emp.SymboisisProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.emp.SymboisisProject.model.ProjectManager;
import com.project.emp.SymboisisProject.repository.ProjectManagerRepository;

@Service
public class ProjectManagerServiceImpl implements ProjectManagerService {
	@Autowired
	private ProjectManagerRepository pmrepo;
	
	@Override
	public ProjectManager addProManager(ProjectManager pm) {
		
		return pmrepo.save(pm);
	}

	@Override
	public void deleteProManager(int id) {
		pmrepo.deleteById(id);
		
	}

	@Override
	public List<ProjectManager> displayProManager() {
	List<ProjectManager> listpm=pmrepo.findAll();
		return listpm ;
	}

	@Override
	public ProjectManager updateProManager(ProjectManager pm) {
		
		return pmrepo.save(pm);
	}

	@Override
	public ProjectManager getById(int id) {
		Optional<ProjectManager> findbyid=pmrepo.findById(id);
		ProjectManager pm=findbyid.get();
		return pm;
	}

	@Override
	public ProjectManager findByEmail(String email) {
	
		return pmrepo.findByEmail(email);
	}

}
