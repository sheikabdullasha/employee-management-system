package com.jrp.pma.Controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.DAO.EmployeeRepository;
import com.jrp.pma.DAO.ProjectRepository;
import com.jrp.pma.dto.Employeeproject;
import com.jrp.pma.dto.Projectstatus;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

@Controller

public class HomeController {
	@Autowired
	ProjectRepository prorep;
	@Autowired
	EmployeeRepository emprep;
	@GetMapping("/")
	public String homedisplay(Model model) throws JsonProcessingException {
		Map<String,Object> map=new HashMap<>();
		
		List<Project> project=prorep.findAll();
		model.addAttribute("projectslist",project);
		
		List<Projectstatus> projectdata=prorep.projectsCount();
		
		ObjectMapper objectmapper=new ObjectMapper();
		String jsonString=objectmapper.writeValueAsString(projectdata);
		model.addAttribute("projectscount", jsonString);
		
		List<Employeeproject> emp=emprep.employeeprojectcount();
		model.addAttribute("employeelistprojectcnt",emp);
		
		return "Main/Home";
		
	}
	
}
