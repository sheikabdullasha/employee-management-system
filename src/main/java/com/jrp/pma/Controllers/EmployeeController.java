package com.jrp.pma.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrp.pma.DAO.EmployeeRepository;
import com.jrp.pma.entities.Employee;
@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeRepository emp1;
	@GetMapping
	public String displayemployees(Model model) {
		List<Employee> employeelist=emp1.findAll();
		model.addAttribute("employeelist", employeelist);
		return "Employees/list-employees";
	}
	
	@GetMapping("/form")
	public String displayemployeeform(Model model) {
		Employee emp=new Employee();
		model.addAttribute("employee", emp);
		return "Employees/emp-form";
		
	}
	
	@PostMapping("/save")
	public String createemployee(Model model,Employee emp) {
		emp1.save(emp);
		return "redirect:/employees/form";
		
	}
}
