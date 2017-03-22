package com.pms.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pms.domain.Project;

public class ProjectRowMapper implements RowMapper<Project> {

	@Override
	public Project mapRow(ResultSet resultSet, int arg1) throws SQLException {
		ProjectExtractor projectExtractor = new ProjectExtractor();
		return projectExtractor.extractData(resultSet);
	}
	

}
