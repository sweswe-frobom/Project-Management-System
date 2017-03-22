package com.pms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pms.domain.Project;
import com.pms.jdbc.ProjectRowMapper;

public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	DataSource dataSource;

	public List<Project> getAllProjectName() {
		String sql = "select * from project";
		List<Project> projectList = new ArrayList<Project>();

		JdbcTemplate template = new JdbcTemplate(dataSource);
		projectList = template.query(sql, new ProjectRowMapper());
		return projectList;
	}

	public void saveProject(String projectName, String startDate, String endDate, int teamId) {

		String sql = "INSERT INTO project "
				+ "(projectname,projectstartdate, projectenddate, teamid) VALUES (?, ?, ?,?)";

		JdbcTemplate template = new JdbcTemplate(dataSource);

		template.update(sql, new Object[] { projectName, startDate, endDate, teamId });

	}

	public String getProjectIdbyName(String projectName) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		String sql = "select projectid from project where projectname=?";
		String projectid = template.queryForObject(sql, new Object[] { projectName }, String.class);

		return projectid;

	}

}
