package com.pms.services;

import java.util.List;

import com.pms.domain.User;

public interface UserService {
	
	public String getProjectCreatorIdByCreatorName(String creatorname);

	public List<User> getUserNameByUserId(int userid);

	public User getUserName(int userid);

}
