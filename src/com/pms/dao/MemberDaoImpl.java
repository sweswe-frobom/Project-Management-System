package com.pms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pms.domain.Member;
import com.pms.jdbc.MemberRowMapper;

public class MemberDaoImpl implements MemberDao {

	@Autowired
	DataSource dataSource;

	public void updateProjectMemberRole(int projectid, int userid, int teamid) {

		JdbcTemplate template = new JdbcTemplate(dataSource);
		int projectmemberrole = 1;

		String sql = "UPDATE member" + " SET projectid=?, projectmemberrole=?" + " WHERE userid=? AND teamid=?";

		template.update(sql, new Object[] { projectid, projectmemberrole, userid, teamid });
	}

	public List<Member> getUserIdByTeamId(int teamid) {

		String sql = "select * from member where teamid=?";
		List<Member> memberList = new ArrayList<Member>();

		JdbcTemplate template = new JdbcTemplate(dataSource);
		memberList = template.query(sql, new Object[] { teamid }, new MemberRowMapper());
		return memberList;

	}

	public void updateMember(int projectId, int userid, int teamid) {

		JdbcTemplate template = new JdbcTemplate(dataSource);

		String query = "update member set projectid='" + projectId + "'" + "where userid='" + userid + "'"
				+ " and teamid='" + teamid + "'";
		template.update(query);

	}

	public List<Member> getUserIdByProjectIdAndTeamId(int projectid, int teamid) {

		String sql = "select * from member where projectid=? and teamid=?";
		List<Member> memberList = new ArrayList<Member>();

		JdbcTemplate template = new JdbcTemplate(dataSource);
		memberList = template.query(sql, new Object[] { projectid, teamid }, new MemberRowMapper());
		return memberList;
	}

	public List<Member> getProjectIdByUserId(int userid) {
		String sql = "select * from member where userid=?";
		List<Member> memberList = new ArrayList<Member>();

		JdbcTemplate template = new JdbcTemplate(dataSource);
		memberList = template.query(sql, new Object[] { userid }, new MemberRowMapper());
		return memberList;
	}

}
