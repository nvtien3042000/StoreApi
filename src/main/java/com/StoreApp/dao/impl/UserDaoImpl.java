package com.StoreApp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.StoreApp.dao.UserDao;
import com.StoreApp.jdbc.DBConnection;
import com.StoreApp.utils.SqlUtils;

public class UserDaoImpl implements UserDao{
	
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement preStatement;
	private static ResultSet rs;

	static {
		conn = DBConnection.getConnection();
	}
	
	@Override
	public boolean addUser(String userName, String password, String email, String phoneNumber, String avatar,
			Integer role) {
		boolean result = true;
		String sql = "\r\n"
				+ "INSERT INTO  user (`userName`, `password`, `email`,"
				+ " `phoneNumber`, `avatar`, `role`) "
				+ "VALUES (?, ?, ?, ?, ?, ?);";
		try {
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, userName);
			preStatement.setString(2, password);
			preStatement.setString(3, email);
			preStatement.setString(4, phoneNumber);
			preStatement.setString(5, avatar);
			preStatement.setInt(6, role);
			result = preStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SqlUtils.close(rs, preStatement);
		}
		
		return result;
		
	}
	
	@Override
	public Map<String, String> login(String email, String password) {
		Map<String, String> result = new HashMap<>();
		String sql = "SELECT id, userName, role FROM user\r\n"
				+ "WHERE email = '" + email + "' AND password = '" + password + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result.put("id", rs.getString("id"));
				result.put("userName", rs.getString("userName"));
				result.put("role", rs.getString("role"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SqlUtils.close(rs, preStatement);
		}
		
		return result;
	}
	
}
