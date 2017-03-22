package com.pms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pms.dao.UserDao;
import com.pms.domain.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;

	public String getProjectCreatorIdByCreatorName(String creatorname) {
		return userdao.getProjectCreatorIdByCreatorName(creatorname);
	}

	public List<User> getUserNameByUserId(int userid) {
		return userdao.getUserNameByUserId(userid);
	}

	public User getUserName(int userid) {
		return userdao.getUserName(userid);
	}

}
