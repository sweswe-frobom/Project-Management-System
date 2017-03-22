package com.pms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pms.dao.ProjectDao;
import com.pms.domain.Project;

public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDao projectdao;

	public void saveProject(String projectName, String startDate, String endDate, int teamId) {
		projectdao.saveProject(projectName, startDate, endDate, teamId);

	}
	
	public List<Project> getAllProjectName()
	{
		List<Project> projectNameList=projectdao.getAllProjectName();
		return projectNameList;
		
		
	}
	
	public String getProjectIdbyName(String projectName) {
		String projectId= projectdao.getProjectIdbyName(projectName);
		return projectId;
	}

}
