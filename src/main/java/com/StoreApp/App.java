package com.StoreApp;

import com.StoreApp.dao.TextDao;
import com.StoreApp.dao.impl.TextDaoImpl;
import com.StoreApp.service.ProductService;
import com.StoreApp.service.TextService;
import com.StoreApp.service.impl.ProductServiceImpl;
import com.StoreApp.service.impl.TextServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	
	private static TextDao textDao;
	private static TextService textService;
	private static ProductService productService;
	static {
		textService = new TextServiceImpl();
		productService = new ProductServiceImpl();
	}
	static {
		textDao = new TextDaoImpl();
	}
	
	public static void main(String[] args) {
//		System.out.println(textService.getAll());
		
//		String aString = "1,2";
//		System.out.println(aString.split(",")[1]);
//		aString.split(",").toString();
//		System.out.println(productService.getAll());
	}
}
