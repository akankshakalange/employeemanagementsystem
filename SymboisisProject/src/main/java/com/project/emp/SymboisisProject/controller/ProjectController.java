package com.project.emp.SymboisisProject.controller;

import java.util.ArrayList;
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
import com.project.emp.SymboisisProject.model.Project;
import com.project.emp.SymboisisProject.model.ProjectManager;
import com.project.emp.SymboisisProject.model.ProjectManagerLog;
import com.project.emp.SymboisisProject.repository.EmployeeRepository;
import com.project.emp.SymboisisProject.service.EmployeeService;
import com.project.emp.SymboisisProject.service.ProjectManagerService;
import com.project.emp.SymboisisProject.service.ProjectService;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@Transactional
public class ProjectController {
	@Autowired
	private ProjectService proser;
	@Autowired
	private ProjectManagerService promngser;
	@Autowired
	private EmployeeService empser;
	@GetMapping("/add/project")
	public String addProject(Model model) {
		List<ProjectManager> existingpro=promngser.displayProManager();
		model.addAttribute("promng",existingpro);
		
		model.addAttribute("newProject",new Project());
		return "addproject";
	}
	@PostMapping("/projectaction")
	public String addprojectStatus(@Valid @ModelAttribute("newProject") Project pr,Model model,BindingResult br) {
		if(br.hasErrors()) {
			return "addproject";
		}
		proser.addProject(pr);
		model.addAttribute("msg","Project added sucessfully!");
		return "addproject";
	}
	
	@GetMapping("/promng/login/status")
	public String viewProjectpro(@Valid @ModelAttribute("PromngLog") ProjectManagerLog prolog,Model model,HttpSession session) {
	//	String email=prolog.getEmail();
		ProjectManager loggedInProjectMng=(ProjectManager) session.getAttribute("loggedInProjectMng");
		  String email = loggedInProjectMng.getEmail();
		System.out.println(email);
		 if (email == null) {
		        // Redirect to login if session is not available
		        return "redirect:/promng/login?error";
		    }
		List<Project> viewpro=proser.displayProject();
		List<Project> list=new ArrayList<Project>();
		for(Project prolist:viewpro) {
			if(prolist.getProjectManager().equals(email)) {
			list.add(prolist);
			}
		}
		model.addAttribute("viewpro",list);
		return "viewprojectpro";
		
	}
	//emp project display
	@GetMapping("/emp/login/status")
	public String viewProjectEmp(@Valid @ModelAttribute("EmployeeLog") Employee emp,Model model,HttpSession session) {
		//	String email=prolog.getEmail();
		   Employee loggedInEmployee = (Employee) session.getAttribute("loggedInEmp");
			  String email = loggedInEmployee.getEmail();
			
			 if (email == null) {
			        // Redirect to login if session is not available
			        return "redirect:/emp/login?error";
			    }
			List<Project> viewpro=proser.displayProject();
			List<Project> list=new ArrayList<Project>();
			for(Project prolist:viewpro) {
				if(prolist.getProjectEmployee().equals(email)) {
				list.add(prolist);
				}
			}
			model.addAttribute("viewemp",list);
			return "viewprojectEmp";
			 
			 

			
		}
	
	//assign employee to project by project manager
	@GetMapping("/project/emp/add")
	public String addEmpTOproject(@RequestParam("projectId") int projectId,Model model) {
		List<Employee> employee=empser.displayEmp();
		model.addAttribute("employee",employee);
		Project project=proser.progetbyid(projectId);
		model.addAttribute("empProject",project);
		return "addprojectEmployee";
		
	}

	@PostMapping("/project/emp/edit")
	public String getEmployeeUpdate( @Valid @ModelAttribute("empProject") Project pro,BindingResult br) {
		if(br.hasErrors()) {
			return "addprojectEmployee";
		}
		  Project existingProject = proser.progetbyid(pro.getProjectId());
		  existingProject.setProjectEmployee(pro.getProjectEmployee());
		  
	proser.addProject(existingProject);
		  
		return "redirect:/promng/login/status";
				
	}
	


}
