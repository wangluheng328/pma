package com.wes.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wes.pma.dto.EmployeeProject;
import com.wes.pma.entities.Employee;

//dao: data access object: where you can access the data in the db
//JpaRepository extends PagingAndSortingRepository which extends CrudRepository

@RepositoryRestResource(collectionResourceRel="api-employees", path="api-employees")
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Override
	List<Employee> findAll();
	
	// nativeQuery=true is to let the database execute the sql query as-is, if set to false, then the parameters in the query
	// should be the names of the java classes, instead of the actual table names in the database
	@Query(nativeQuery = true, value = "SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount " +
										"FROM employee e left join project_employee pe ON e.employee_id = pe.employee_id " + 
										"GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
	public List<EmployeeProject> employeeProjects();
	
	
}
