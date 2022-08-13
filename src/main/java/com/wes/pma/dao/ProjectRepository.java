package com.wes.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wes.pma.dto.ChartData;
import com.wes.pma.entities.Project;

@RepositoryRestResource(collectionResourceRel="api-projects", path="api-projects")
public interface ProjectRepository extends JpaRepository<Project, Long> {
	// enable to insert data into db
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery = true, value = "SELECT stage as label, COUNT(*) as count FROM project GROUP BY stage")
	public List<ChartData> getProjectStatus();
}
