package com.pms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pms.domain.User;
import com.pms.jdbc.UserRowMapper;

public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource dataSource;

	public String getProjectCreatorIdByCreatorName(String creatorname) {

		JdbcTemplate template = new JdbcTemplate(dataSource);

		String sql = "select userid from user where username=?";

		String creatorId = (String) template.queryForObject(sql, new Object[] { creatorname }, String.class);
		return creatorId;

	}

	public List<User> getUserNameByUserId(int userid) {

		JdbcTemplate template = new JdbcTemplate(dataSource);

		String sql = "select * from user where userid='" + userid + "'";

		List<User> userNameList = new ArrayList<User>();
		userNameList = template.query(sql, new UserRowMapper());
		return userNameList;

	}

	public User getUserName(int userid) {
		JdbcTemplate template = new JdbcTemplate(dataSource);

		String sql = "select * from user where userid='" + userid + "'";

		List<User> userNameList = new ArrayList<User>();
		userNameList = template.query(sql, new UserRowMapper());
		return userNameList.get(0);

	}

}
