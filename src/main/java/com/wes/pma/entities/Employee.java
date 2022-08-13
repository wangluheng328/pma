package com.wes.pma.entities;

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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Employee {
	
	
	// identity: make the database instead of hibernate to take care of incrementing primary key (di 25 ke)
	// use sequence instead of identity to enable batch processing
	@Id
	@SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq",allocationSize = 1,initialValue=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq") 
	private long employeeId;
	
	@NotNull
	@Size(min=2, max=50)
	private String firstName;
	
	@NotNull
	@Size(min=2, max=50)
	private String lastName;
	
	@NotNull
	@Email
	private String email;
	
	//cascade detach.remove: deleting project will also delete all the associated employees
	// fetchtype lazy: when query project table, related entities will not be loaded into the memory; eager: all related will be loaded, bad performance
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
				fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee", 
				joinColumns = @JoinColumn(name = "employee_id"), // the foreign key associated with this entity (employee)
				inverseJoinColumns = @JoinColumn(name = "project_id"))  // the foreign key associated with the other entity (project)
	private List<Project> projects;
	
	
	public Employee() {
		
	}
	
	
	
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	

	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
