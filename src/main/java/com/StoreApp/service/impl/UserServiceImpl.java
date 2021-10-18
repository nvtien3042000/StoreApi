package com.StoreApp.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.StoreApp.dao.UserDao;
import com.StoreApp.dao.impl.UserDaoImpl;
import com.StoreApp.service.UserService;

public class UserServiceImpl implements UserService{
	private static UserDao userDao;
	static {
		userDao = new UserDaoImpl();
	}
	@Override
	public boolean addUser(String userName, String password, String email, String phoneNumber, String avatar,
			Integer role) {
		return userDao.addUser(userName, password, email, phoneNumber, avatar, role);
	}
	
	@Override
	public Map<String, String> login(String email, String password) {
		Map<String, String> result = userDao.login(email, password);
		if(result.size() == 0) {
			result.put("id", "");
			result.put("userName", "");
			result.put("role", "false");
		}
		if(result.get("role").equals("1")) {
			result.replace("role", "1", "user");
		}
		if(result.get("role").equals("2")) {
			result.replace("role", "2", "admin");;
		}
		return result;
	}
}
