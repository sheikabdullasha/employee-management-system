package com.jrp.pma.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jrp.pma.DAO.EmployeeRepository;
import com.jrp.pma.DAO.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	ProjectRepository pro; 
	@Autowired
	EmployeeRepository emps;
	@GetMapping
	public String displayprojects(Model model) {
		List<Project> projects=pro.findAll();
		
		model.addAttribute("projectlist", projects);
		return "Projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayprojectform(Model model) {
		Project aproject=new Project();
		List<Employee> empp=emps.findAll();
		model.addAttribute("project",aproject);
		
		
		model.addAttribute("employeees", empp);
		
		return "Projects/new-project";
		
	}
	@PostMapping("/save")
	public String createnewproject(Model model,Project project,@RequestParam List<Long> employeeslist) {
		
		pro.save(project);
		
		
		return "redirect:/projects/new";
		
	}
	

}
