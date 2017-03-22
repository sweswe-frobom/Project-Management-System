package com.pms.dao;

import java.util.List;

import com.pms.domain.User;

public interface UserDao {
	
	public String getProjectCreatorIdByCreatorName(String creatorname);

	public List<User> getUserNameByUserId(int userid);
	
	public User getUserName(int userid);
	
	
}
