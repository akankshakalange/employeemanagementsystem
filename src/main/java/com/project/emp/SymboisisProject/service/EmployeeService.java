package com.project.emp.SymboisisProject.service;

import java.util.List;

import com.project.emp.SymboisisProject.model.Employee;

public interface EmployeeService {
public Employee addEmp(Employee emp);
public void deleteEmp(int id);
public List<Employee> displayEmp();
public Employee updateEmp(Employee emp);
public Employee getById(int id);
Employee findByEmail(String email);

}
