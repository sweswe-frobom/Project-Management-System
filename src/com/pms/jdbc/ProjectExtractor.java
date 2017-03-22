package com.pms.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pms.domain.Project;

public class ProjectExtractor implements ResultSetExtractor<Project> {

	public Project extractData(ResultSet resultSet) throws SQLException, DataAccessException {

		Project project = new Project();
		project.setProjectId(resultSet.getInt(1));
		project.setProjectName(resultSet.getString(2));
		project.setProjectStartDate(resultSet.getString(3));
		project.setProjectEndDate(resultSet.getString(4));
		project.setTeamId(resultSet.getInt(5));

		return project;

	}

}
