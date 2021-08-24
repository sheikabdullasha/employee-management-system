package com.jrp.pma.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.Projectstatus;
import com.jrp.pma.entities.Project;


public interface ProjectRepository extends CrudRepository<Project,Long>{
	
	@Override
	public List<Project> findAll();
	@Query(nativeQuery=true,value="select status as Label,count(*) as status from project group by Status")
	public List<Projectstatus> projectsCount();

}
