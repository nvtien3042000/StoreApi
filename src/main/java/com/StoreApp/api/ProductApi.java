package com.StoreApp.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.StoreApp.model.Page;
import com.StoreApp.model.Product;
import com.StoreApp.service.ProductService;
import com.StoreApp.service.impl.ProductServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@WebServlet(urlPatterns = {"/products"})
public class ProductApi extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ProductService productService;
	static {
		productService = new ProductServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> lists = new ArrayList<>();
		int limitOfPage = Integer.parseInt(req.getParameter("limitOfPage"));
		int page = Integer.parseInt(req.getParameter("page"));
		if(req.getParameter("category") != null) {
			System.out.println(req.getParameter("category"));
			lists = productService.getProductsByCategory(
									req.getParameter("category"),
									limitOfPage,
									page);
		} else {
			lists = productService.getAll(Integer.parseInt(req.getParameter("limitOfPage")),
					Integer.parseInt(req.getParameter("page")));
		}
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		PrintWriter out = resp.getWriter();
		String resultJsonString=gson.toJson(lists);
		Page pageModel = new Page(limitOfPage, page, lists.size());
		resultJsonString = "{'data':"+resultJsonString+","+"'pagination':"+pageModel.toString()+"}";
		JSONObject jsonObject = new JSONObject(resultJsonString);
		out.print(jsonObject);
		out.flush();
	}
}
