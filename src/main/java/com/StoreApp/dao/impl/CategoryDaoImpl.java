package com.StoreApp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.StoreApp.dao.CategoryDao;
import com.StoreApp.jdbc.DBConnection;
import com.StoreApp.model.Category;
import com.StoreApp.utils.SqlUtils;

public class CategoryDaoImpl implements CategoryDao{
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;

	static {
		conn = DBConnection.getConnection();
	}
	@Override
	public List<Category> getAll() {
		List<Category> result = new ArrayList<>();
		String sql = "SELECT * FROM category";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(transformer());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}
	private Category transformer() throws SQLException {
		Category category = new Category();
		category.setId(rs.getInt("id"));
		category.setName(rs.getString("name"));
		category.setDescriptions(Arrays.asList(rs.getString("description").split(",")));
		System.out.println(category);
		return category;
	}
}
