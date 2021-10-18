package com.StoreApp.service;

import java.util.List;

import com.StoreApp.model.Product;

public interface ProductService {
	List<Product> getAll(int limitOfPage, int page);
	List<Product> getProductsByCategory(String category, int limitOfPage, int page);
}
