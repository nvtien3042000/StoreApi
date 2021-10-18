package com.StoreApp.dao;

import java.util.List;
import java.util.Map;

public interface UserDao {
	boolean addUser(String userName, String password, 
					String email, String phoneNumber, String avatar, Integer role);
	Map<String, String> login(String userName, String password);
}
