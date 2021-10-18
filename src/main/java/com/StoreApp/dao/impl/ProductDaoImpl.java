package com.StoreApp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.StoreApp.dao.ProductDao;
import com.StoreApp.jdbc.DBConnection;
import com.StoreApp.model.Product;
import com.StoreApp.utils.SqlUtils;

public class ProductDaoImpl implements ProductDao {

	private static Connection conn;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;

	static {
		conn = DBConnection.getConnection();
	}

	@Override
	public List<Product> getAll(int limitOfPage, int page) {
		List<Product> result = new ArrayList<>();
		String sql = "SELECT P.id, name, \r\n"
				+ "description, price, group_concat(distinct I.link separator ',') as link\r\n" + "FROM product P\r\n"
				+ "JOIN image I\r\n" + "ON  P.id = I.productId\r\n" + "GROUP BY id\r\n"
				+ "LIMIT "+(page*limitOfPage-limitOfPage)+","+(limitOfPage) + ";";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(transformer());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}

	@Override
	public List<Product> getProductsByCategory(String category, int limitOfPage, int page) {
		List<Product> lists = new ArrayList<>();
		String sql = "SELECT P.id, P.name, \r\n"
				+ "P.description, price, group_concat(distinct I.link separator ', ') as link\r\n"
				+ "FROM product P\r\n" + "JOIN image  I\r\n" + "ON  P.id = I.productId\r\n" + "JOIN category C\r\n"
				+ "ON C.id = P.categoryId\r\n" + "WHERE C.name='" + category + "'\r\n" + "GROUP BY id\r\n"
						+ "LIMIT "+(page*limitOfPage-limitOfPage)+","+(limitOfPage) + ";";
		System.out.println(sql);
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				lists.add(transformer());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}

		return lists;
	}

	@Override
	public void insertProduct() {
		String sql1 = "INSERT INTO `store`.`product` (`name`, `description`, `price`, `categoryId`) VALUES ('1A', '1', '11', '1');\r\n";
		try {
			pst = conn.prepareStatement(sql1);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, pst);
		}
		String sql2 = "insert into image(link, productId) values (\"abc\", (select max(id) from product));";
		try {
			pst = conn.prepareStatement(sql2);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
	}

	private Product transformer() throws SQLException {
		Product product = new Product();
		product.setid(rs.getInt("id"));
		product.setname(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setPrice(rs.getDouble("price"));
		product.setImages(Arrays.asList(rs.getString("link").split(",")));
		return product;
	}
}
