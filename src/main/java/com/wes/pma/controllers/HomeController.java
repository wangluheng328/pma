package com.wes.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wes.pma.dto.ChartData;
import com.wes.pma.dto.EmployeeProject;
import com.wes.pma.entities.Project;
import com.wes.pma.services.EmployeeService;
import com.wes.pma.services.ProjectService;

@Controller
public class HomeController {

	
	@Value(value="${version}")
	private String ver;
	// tell spring context to inject a projectrepository instance into this class
//	@Autowired
//	ProjectRepository proRepo;
//	@Autowired
//	EmployeeRepository empRepo;
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		
		model.addAttribute("versionNumber", ver);
		
		// we are querying the database for projects
		List<Project> projects = proService.getAll();
		model.addAttribute("projectsList", projects);
		
		List<ChartData> projectData = proService.getProjectStatus();
		// this list looks like:
		// ["NOTSTARTED", 1], ["INPROGRESS", 2] ...]
		
		// convert projectData object into a json structure for use in javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		
		model.addAttribute("projectStatusCnt", jsonString);
		
		// we are querying the database for employees
		List<EmployeeProject> employeesProjectCnt = empService.employeeProjects();
		model.addAttribute("employeesListProjectsCnt", employeesProjectCnt);
		
		return "main/home";
	}
}	

