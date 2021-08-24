package com.jrp.pma.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.JoinColumn;
@Entity
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long projectId;
	private String name;
	private String status;
	private String description;
	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
			fetch=FetchType.LAZY)
	@JoinTable(name="project_employee",
	joinColumns=@JoinColumn(name="projectId"),
	inverseJoinColumns=@JoinColumn(name="employeeId")
	)
	private List<Employee> employeeslist;
	
	
	public List<Employee> getEmployeeslist() {
		return employeeslist;
	}

	public void setEmployeeslist(List<Employee> employeeslist) {
		this.employeeslist = employeeslist;
	}

	public Project() {
		
	}
	
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public Project(String name, String status, String description) {
		super();
		this.name = name;
		this.status = status;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void addEmployees (Employee emp) {
		if(employeeslist==null) {
			employeeslist=new ArrayList<>();
		}
		employeeslist.add(emp);
	}
	
}
