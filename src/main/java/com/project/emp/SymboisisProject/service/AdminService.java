package com.project.emp.SymboisisProject.service;

import java.util.List;

import com.project.emp.SymboisisProject.model.Admin;
import com.project.emp.SymboisisProject.model.Employee;

public interface AdminService {
public Admin saveAdmin(Admin ad);
public List<Admin> displayData();
public Admin getById(int id);
public Admin findByUsername(String username);
}
