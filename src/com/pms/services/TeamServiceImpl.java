package com.pms.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.pms.dao.TeamDao;

public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamDao teamdao;

	public int getTeamIdByName(String teamname) {
		return teamdao.getTeamIdByName(teamname);

	}

}
