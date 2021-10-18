package com.StoreApp.dao;

import java.util.List;

import com.StoreApp.model.Product;

public interface ProductDao {
	List<Product> getAll(int limitOfPage, int page);
	List<Product> getProductsByCategory(String category, int limitOfPage, int page);
	void insertProduct();
}
