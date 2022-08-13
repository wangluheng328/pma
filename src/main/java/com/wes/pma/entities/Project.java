package com.wes.pma.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

// this class is mapped to a row/record in the database table
@Entity
public class Project {
	
	@Id
	@SequenceGenerator(name = "project_seq", sequenceName = "project_seq", allocationSize = 1,initialValue=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq") 
	private long projectId;
	
	private String name;
	private String stage; //NOTSTARTED, COMPLETED, INPROGRESS
	private String description;
	
	// employee relationship: 1 project -> many employees, or many to many
	// if oneToMany, we can use mappedBy to create a projectId foreign key in employee table
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee", 
				joinColumns = @JoinColumn(name = "project_id"), // the foreign key associated with this entity (project)
				inverseJoinColumns = @JoinColumn(name = "employee_id"))  // the foreign key associated with the other entity (employee)
	@JsonIgnore
	private List<Employee> employees;
	
	public Project() {}
	
	public Project(String name, String stage, String description) {
		super();
		// database responsible for projectId
		this.name = name;
		this.stage = stage;
		this.description = description;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addEmployee(Employee emp) {
		if (employees == null) {
			employees = new ArrayList<>();
		}
		employees.add(emp);
	}
	
}
