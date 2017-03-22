package com.pms.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pms.domain.Member;

public class MemberExtractor implements ResultSetExtractor<Member> {

	public Member extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {

		Member member = new Member();
		member.setMemberId(resultSet.getInt(1));
		member.setMemberRole(resultSet.getInt(2));
		member.setProjectId(resultSet.getInt(3));
		member.setTeamId(resultSet.getInt(4));
		member.setUserId(resultSet.getInt(5));
		member.setProjectMemberRole(resultSet.getInt(6));

		return member;

	}

}
