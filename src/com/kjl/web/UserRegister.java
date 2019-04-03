package com.kjl.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjl.dao.impl.News_userDaoimpl;
import com.kjl.entity.News_user;

public class UserRegister extends HttpServlet {

	
	public UserRegister() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		 request.setCharacterEncoding("utf-8");
       	response.setCharacterEncoding("utf-8");
       	
       	String name = request.getParameter("user");
       	String pwd =request.getParameter("pwds");
       	String email = request.getParameter("email");
       	String type = request.getParameter("usertype");
       	
       	
       	System.out.println("..................."+type);
       	News_userDaoimpl news = new News_userDaoimpl();
       	int i = Integer.parseInt(type);
       	System.out.println(i+"是多少");
       	News_user newsuser = new News_user(name,pwd,email,i);
       	
       	boolean flag=true;
		try {
			flag = news.add(newsuser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	if(flag){
       	response.sendRedirect("login.jsp");
       	
      	}else{
       	request.getRequestDispatcher("register.jsp").forward(request, response);
        	}
       	
       	
       	
	
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
