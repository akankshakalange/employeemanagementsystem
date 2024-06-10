package com.project.emp.SymboisisProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.emp.SymboisisProject.model.Employee;
import com.project.emp.SymboisisProject.model.ProjectManager;
@Repository
public interface ProjectManagerRepository extends JpaRepository<ProjectManager, Integer> {
	ProjectManager findByEmail(String email);
}
