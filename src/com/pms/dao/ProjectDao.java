package com.pms.dao;

import java.util.List;

import com.pms.domain.Project;

public interface ProjectDao {

	public List<Project> getAllProjectName();

	public void saveProject(String projectName, String startDate, String endDate, int teamId);
	
	public String getProjectIdbyName(String projectName);

}
