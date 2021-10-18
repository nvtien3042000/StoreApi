package com.StoreApp.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StoreApp.service.UserService;
import com.StoreApp.service.impl.UserServiceImpl;
import com.google.gson.Gson;

@WebServlet(urlPatterns = {"/addUser"})
public class UserApi extends HttpServlet{
	private static UserService userService;
	static {
		userService = new UserServiceImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		boolean result = userService.addUser(req.getParameter("userName"),
											req.getParameter("password"),
											req.getParameter("email"),
											req.getParameter("phoneNumber"),
											req.getParameter("avatar"),
											Integer.parseInt(req.getParameter("role")));
		Gson gson = new Gson();
		PrintWriter out = resp.getWriter();
		if(result) {
			out.print(gson.toJson("false"));
		}else {
			out.print(gson.toJson("true"));
		}
		out.flush();
	}
	
}
