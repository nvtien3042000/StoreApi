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

import com.StoreApp.model.Text;
import com.StoreApp.service.TextService;
import com.StoreApp.service.impl.TextServiceImpl;
import com.google.gson.Gson;

@WebServlet(urlPatterns = {"/text"})
public class textApi extends HttpServlet {
	
	private static TextService textService;
	static {
		textService = new TextServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Text> lists = textService.getAll();
		Gson gson = new Gson();
		PrintWriter out = resp.getWriter();
		out.print(gson.toJson(lists));
		out.flush();
	}
}
