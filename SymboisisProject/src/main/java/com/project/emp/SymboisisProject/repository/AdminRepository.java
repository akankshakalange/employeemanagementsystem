package com.project.emp.SymboisisProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.emp.SymboisisProject.model.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
public Admin findByUsername(String username);
}
