package com.kjl.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kjl.dao.News_detailDao;
import com.kjl.dao.impl.News_detailsDaoimpl;
import com.kjl.entity.News_detail;

public class NewsDel extends HttpServlet {

	public NewsDel() {
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
		  News_detail news = new News_detail();
		     
		     String id = request.getParameter("id");
		     
		     News_detailDao newsdao = new News_detailsDaoimpl();
		     
		     int num =  newsdao.deleteNews(Integer.parseInt(id));
		     
		     if (num>0){
		       response.sendRedirect("deletsuccess.jsp");
		     }else{
		       response.sendRedirect("deletnosuccess.jsp");
		        
		     }
		     
	
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
