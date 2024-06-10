
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
import com.project.emp.SymboisisProject.model.EmployeeLog;
import com.project.emp.SymboisisProject.service.EmployeeService;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@Transactional
public class EmployeeController {
	@Autowired
	private EmployeeService empser;
	
	
	//login
	
	@GetMapping("/emp/login")
	public String getemployeeLogin(Model model) {
		model.addAttribute("EmployeeLog",new EmployeeLog());
		return "emplogin";
	}
	@PostMapping("/emp/login/status")
	public String getemplogstatus(@Valid @ModelAttribute("EmployeeLog") EmployeeLog emplog,BindingResult br,HttpSession session) {
		String user=emplog.getEmail();
		
		String pass=emplog.getPassword();
		boolean found=false;
		boolean check=false;
		List<Employee> list=empser.displayEmp();
		for(Employee emp:list) {
			if(emp.getEmail().equals(user) && emp.getPassword().equals(pass)) {
				found=true;
			}
		}
		 Employee employee = empser.findByEmail(user);
		if(found==true) {
			
			session.setAttribute("loggedInEmp", employee);
			 return "redirect:/emp/dashboard";
		}
		return "redirect:/emp/login?error";
	}
	
	 @GetMapping("/emp/dashboard")
	public String showDashboardemp(HttpSession session, Model model) {
        Employee loggedInEmployee = (Employee) session.getAttribute("loggedInEmp");
        if (loggedInEmployee == null) {
            return "redirect:/emp/login";
        }
        model.addAttribute("employeeName", loggedInEmployee.getName());
        return "empdash";
	}
	@GetMapping("/add/emp")
	public String getEmpList(Model model) {
		model.addAttribute("newEmp",new Employee());
		return "addemployee";
		
	}
	
	@PostMapping("/employeeaction")
	public String getNewBook(@Valid @ModelAttribute("newEmp") Employee emp ,BindingResult br,Model model ) {
		if(br.hasErrors()) {
			return "addemployee";
		}
		empser.addEmp(emp);
		model.addAttribute("msg","Employee added sucessfully!");
		return "addemployee";
		
	}
	
	@GetMapping("/existingemp")
	public String getExistingEmployee(Model model ) {
		List<Employee> existingemp=empser.displayEmp();
		model.addAttribute("employees",existingemp);
		return "existingemp";
	}
	
	
@PostMapping("/emp/delete")
public String deleteEmployee(@RequestParam("empid") int empid) {
	empser.deleteEmp(empid);
	return "redirect:/existingemp";
	
}

@GetMapping("/emp/update")
public String updateEmployeeForm(@RequestParam("empid") int empid,Model model) {
	Employee employee=empser.getById(empid);
	model.addAttribute("employee",employee);
	
	return "updatemp_form";
	
}

@PostMapping("emp/edit")
public String getEmployeeUpdate(@Valid @ModelAttribute("employee") Employee empl,BindingResult br) {
	if(br.hasErrors()) {
		return "updatemp_form";
	}
	empser.updateEmp(empl);
	return "redirect:/existingemp";
			
}

@GetMapping("/emp/logout")
public String logoutEmployee(HttpSession session) {
    // Invalidate the session
    session.invalidate();
    // Redirect to the login page
    return "redirect:/emp/login";
}
}
