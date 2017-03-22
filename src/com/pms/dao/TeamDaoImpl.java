package com.pms.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pms.domain.Team;

public class TeamDaoImpl implements TeamDao {

	@Autowired
	DataSource dataSource;

	public int getTeamIdByName(String teamname) {
		String query = "select teamid from team where teamname=?";
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		//int teamId = (int) getTemplate().queryForObject(query, new Object[] { teamname },
		//		new BeanPropertyRowMapper(Team.class));

	//	return teamId;
				return 0;
	}

}
