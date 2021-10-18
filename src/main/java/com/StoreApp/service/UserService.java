package com.StoreApp.service;

import java.util.List;
import java.util.Map;

public interface UserService {
	boolean addUser(String userName, String password, 
			String email, String phoneNumber, String avatar, Integer role);
	Map<String, String> login(String email, String password);
}
