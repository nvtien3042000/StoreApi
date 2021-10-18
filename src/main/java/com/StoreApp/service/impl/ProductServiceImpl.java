package com.StoreApp.service.impl;

import java.util.List;

import com.StoreApp.dao.ProductDao;
import com.StoreApp.dao.impl.ProductDaoImpl;
import com.StoreApp.model.Product;
import com.StoreApp.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	private static ProductDao productDao;
	static {
		productDao = new ProductDaoImpl();
	}
	
	@Override
	public List<Product> getAll(int limitOfPage, int page) {
		return productDao.getAll(limitOfPage, page);
	}
	
	@Override
	public List<Product> getProductsByCategory(String category,int limitOfPage, int page) {
		// TODO Auto-generated method stub
		
		return productDao.getProductsByCategory(category, limitOfPage, page);
	}
}
