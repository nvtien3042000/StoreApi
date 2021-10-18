package com.StoreApp.service.impl;

import java.util.List;

import com.StoreApp.dao.CategoryDao;
import com.StoreApp.dao.impl.CategoryDaoImpl;
import com.StoreApp.model.Category;
import com.StoreApp.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	
	private static CategoryDao categoryDao;
	static {
		categoryDao = new CategoryDaoImpl();
	}
	@Override
	public List<Category> getAll() {
		return categoryDao.getAll();
	}
}
