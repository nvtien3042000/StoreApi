package com.StoreApp.service.impl;

import java.util.List;

import com.StoreApp.dao.TextDao;
import com.StoreApp.dao.impl.TextDaoImpl;
import com.StoreApp.model.Text;
import com.StoreApp.service.TextService;

public class TextServiceImpl implements TextService {
	private static TextDao textDao;
	
	static {
		textDao = new TextDaoImpl();
	}
	
	@Override
	public List<Text> getAll() {
		return textDao.getAll();
	}
}
