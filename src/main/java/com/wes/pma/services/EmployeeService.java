package com.wes.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wes.pma.dao.EmployeeRepository;
import com.wes.pma.dto.EmployeeProject;
import com.wes.pma.entities.Employee;

@Service
public class EmployeeService {
	
	
	// field injection
	@Autowired
	EmployeeRepository empRepo;


	// constructor injection
//	public EmployeeService(EmployeeRepository empRepo) {
//		super();
//		this.empRepo = empRepo;
//	}
	
	//setter injection
	
//	@Autowired
//	public void setEmpRepo(EmployeeRepository empRepo) {
//		this.empRepo = empRepo;
//	}
	

	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}


	public Iterable<Employee> getAll() {
		return empRepo.findAll();
	}


	public List<EmployeeProject> employeeProjects() {
		return empRepo.employeeProjects();
	}


	
}
