package com.project.emp.SymboisisProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.emp.SymboisisProject.model.Employee;
import com.project.emp.SymboisisProject.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository emprepo;

	@Override
	public Employee addEmp(Employee emp) {
		
		return emprepo.save(emp);
	}

	@Override
	public void deleteEmp(int id) {
		emprepo.deleteById(id);
		
	}

	@Override
	public List<Employee> displayEmp() {
		List<Employee> emplist=emprepo.findAll();
		return emplist;
	}

	@Override
	public Employee updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		 return emprepo.save(emp);
	}

	@Override
	public Employee getById(int id) {
		Optional<Employee> findbyid=emprepo.findById(id);
		Employee emp=findbyid.get();
		return emp;
	}

	@Override
	public Employee findByEmail(String email) {
		
		return emprepo.findByEmail(email);
	}
	
	

}
