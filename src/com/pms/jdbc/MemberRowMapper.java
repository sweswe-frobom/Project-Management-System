package com.pms.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pms.domain.Member;


public class MemberRowMapper implements RowMapper<Member> {
	
	@Override
	public Member mapRow(ResultSet resultSet, int arg1) throws SQLException {
		MemberExtractor memberExtractor = new MemberExtractor();
		return memberExtractor.extractData(resultSet);
	}
	

}
