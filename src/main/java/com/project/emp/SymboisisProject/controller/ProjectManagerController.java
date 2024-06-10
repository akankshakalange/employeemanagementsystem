package com.project.emp.SymboisisProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.emp.SymboisisProject.model.Employee;
import com.project.emp.SymboisisProject.model.ProjectManager;
import com.project.emp.SymboisisProject.model.ProjectManagerLog;
import com.project.emp.SymboisisProject.service.ProjectManagerService;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@Transactional
public class ProjectManagerController {
	@Autowired
	private ProjectManagerService pmser;
	
	@GetMapping("/promng/login")
	public String getPromngLogin(Model model) {
		model.addAttribute("PromngLog",new ProjectManagerLog());
		return "promnglogin";
	}
	
	
	@PostMapping("/promng/login/status")
	public String getPromngLogStatus(@Valid @ModelAttribute("PromngLog") ProjectManagerLog pmlog,BindingResult br,HttpSession session) {
		String user=pmlog.getEmail();
		String pass=pmlog.getPassword();
		boolean found=false;
		boolean check=false;
		List<ProjectManager> list=pmser.displayProManager();
		for(ProjectManager pro:list) {
			if(pro.getEmail().equals(user)&& pro.getPassword().contains(pass)) {
				found=true;
			}
		}
		ProjectManager pm=pmser.findByEmail(user);
		if(found==true) {
			 session.setAttribute("loggedInProjectMng", pm);
			 return "redirect:/promng/dashboard";
		}
		return "redirect:/promng/login?error";
	}
	
	
	@GetMapping("/promng/dashboard")
	public String showDashboard(HttpSession session, Model model) {
		ProjectManager loggedInProjectMng = (ProjectManager) session.getAttribute("loggedInProjectMng");
        if (loggedInProjectMng == null) {
            return "redirect:/promng/login";
        }
        model.addAttribute("promngname", loggedInProjectMng.getName());
        return "promngdash";
	}
	
	@GetMapping("/add/projectmng")
	public String getEmpList(Model model) {
		model.addAttribute("newProMng",new ProjectManager());
		return "addpromanager";
		
	}
	
	
	
	@PostMapping("/promangaction")
	public String getNewBook(@Valid @ModelAttribute("newProMng") ProjectManager promng ,BindingResult br,Model model ) {
		if(br.hasErrors()) {
			return "addpromanager";
		}
		pmser.addProManager(promng);
		model.addAttribute("msg","Project Manager added sucessfully!");
		return "addpromanager";
		
	}
	@GetMapping("/existingpromng")
	public String getExistingProManager(Model model ) {
		List<ProjectManager> existingpro=pmser.displayProManager();
		model.addAttribute("promng",existingpro);
		return "existingpromng";
	}

@PostMapping("/promng/delete")
public String deleteProManager(@RequestParam("proid") int proid) {
	pmser.deleteProManager(proid);
	return "redirect:/existingpromng";
	
}

@GetMapping("/promng/update")
public String updateEmployeeForm(@RequestParam("proid") int proid,Model model) {
	ProjectManager promanager=pmser.getById(proid);
	model.addAttribute("promanger",promanager);
	
	return "updatepromng_form";
	
}

@PostMapping("promng/edit")
public String getEmployeeUpdate(@Valid @ModelAttribute("promanger") ProjectManager prom,BindingResult br) {
	if(br.hasErrors()) {
		return "updatepromng_form";
	}
pmser.updateProManager(prom);
	return "redirect:/existingpromng";
			
}

@GetMapping("/promng/logout")
public String logoutpromng(HttpSession session) {
    // Invalidate the session
    session.invalidate();
    // Redirect to the login page
    return "redirect:/promng/login";
}
}
