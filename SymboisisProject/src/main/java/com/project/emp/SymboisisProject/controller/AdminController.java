package com.project.emp.SymboisisProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.project.emp.SymboisisProject.model.Admin;
import com.project.emp.SymboisisProject.model.AdminLog;
import com.project.emp.SymboisisProject.model.Employee;
import com.project.emp.SymboisisProject.service.AdminService;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@Transactional
public class AdminController {
	@Autowired
	private AdminService adser;
	@GetMapping("/index")
	public String getIndex() {
		return "index";
	}
	@GetMapping("/admin/register")
	public String getRegister(Model model) {
		model.addAttribute("admin",new Admin());
		return "adReg";
		
	}
	@PostMapping("/admin/status")
	public String getStatus(@Valid @ModelAttribute("admin") Admin ad,BindingResult br,MultipartFile mf) {
		if(br.hasErrors()) {
			return "adReg";
		}
		
		adser.saveAdmin(ad);
		return "adstatus";
		
		
	}
	@GetMapping("/admin/login")
	public String getLogin(Model model) {
		model.addAttribute("adminLog", new AdminLog());
		return "adlogin";
	}
	@PostMapping("/admin/login/status")
	public String getStatus(@Valid @ModelAttribute("adminLog") AdminLog ad,BindingResult br,HttpSession session) {
		String user=ad.getUsername();
		String pass=ad.getPassword();
		boolean found =false;
		boolean check=false;
		List<Admin> list=adser.displayData();
		for(Admin admin:list) {
			if(admin.getUsername().equals(user) && admin.getPassword().equals(pass)) {
				found=true;
			}
		}
		Admin admin=adser.findByUsername(user);
		if(found==true) {
			session.setAttribute("loggedInAdmin", admin);
			return "redirect:/admin/dashboard";
		}
		return "redirect:/admin/login?error";
	}
	
	 @GetMapping("/admin/dashboard")
		public String showDashboardadmin(HttpSession session, Model model) {
	        Admin loggedInAdmin = (Admin) session.getAttribute("loggedInAdmin");
	        if (loggedInAdmin == null) {
	            return "redirect:/admin/login";
	        }
	        model.addAttribute("adminname", loggedInAdmin.getName());
	        return "addash";
		}
	 
	 @GetMapping("/admin/logout")
	 public String logoutAdmin(HttpSession session) {
	     // Invalidate the session
	     session.invalidate();
	     // Redirect to the login page
	     return "redirect:/admin/login";
	 }
	
}
