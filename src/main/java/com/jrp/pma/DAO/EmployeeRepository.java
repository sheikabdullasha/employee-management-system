package com.jrp.pma.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.Employeeproject;
import com.jrp.pma.entities.Employee;
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
	
	@Override
	public List<Employee> findAll();
	@Query(nativeQuery=true,value="select e.first_Name as FirstName,e.last_Name as LastName,count(pe.employee_Id) as Projectcount "
			+ "from employee e left join project_employee pe "
			+ "on pe.employee_Id=e.employee_Id "
			+ "group by e.first_Name,e.last_Name order by 3 desc;")
	public List<Employeeproject> employeeprojectcount();
}
