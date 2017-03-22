package com.pms.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pms.domain.User;

public class UserExtractor implements ResultSetExtractor<User> {
	
	public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		User user=new User();
		user.setUserId(resultSet.getInt(1));
		user.setUserName(resultSet.getString(2));
		user.setUserEmail(resultSet.getString(3));
		user.setUserPassword(resultSet.getString(4));
		user.setUserPhoneNo(resultSet.getInt(5));
		user.setUserGender(resultSet.getString(6));
		user.setUserAddress(resultSet.getString(7));
		
		return user;
	}

}
