package com.project.emp.SymboisisProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.emp.SymboisisProject.model.Admin;
import com.project.emp.SymboisisProject.model.Employee;
import com.project.emp.SymboisisProject.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adrepo;
	
	@Override
	public Admin saveAdmin(Admin ad) {
		Admin admin=adrepo.save(ad);
		return admin;
	}

	@Override
	public List<Admin> displayData() {
		List<Admin> list=adrepo.findAll();
		return list;
	}

	@Override
	public Admin getById(int id) {
		Optional<Admin> findbyid=adrepo.findById(id);
		Admin ad=findbyid.get();
		return ad;
	}

	@Override
	public Admin findByUsername(String username) {
		return adrepo.findByUsername(username);
	}

}
