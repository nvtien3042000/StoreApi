package com.StoreApp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.StoreApp.dao.TextDao;
import com.StoreApp.jdbc.DBConnection;
import com.StoreApp.model.Text;

public class TextDaoImpl implements TextDao {
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement preStatement;
	private static ResultSet rs;

	static {
		conn = DBConnection.getConnection();
	}

	@Override
	public List<Text> getAll() {
		List<Text> listsList = new ArrayList<>();
		String sql = "SELECT * FROM nguoidung";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				listsList.add(transformer());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listsList;
	}
	
	private Text transformer() throws SQLException {
		Text text = new Text();
		text.setName(rs.getString("taikhoan"));
		text.setpass(rs.getString("matkhau"));
		text.setRole(rs.getInt("quyen"));
		return text;
	}
}
