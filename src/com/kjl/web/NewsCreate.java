package com.kjl.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kjl.dao.News_detailDao;
import com.kjl.dao.impl.News_detailsDaoimpl;
import com.kjl.entity.News_detail;

public class NewsCreate extends HttpServlet {

	public NewsCreate() {
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
		 request.setCharacterEncoding("utf-8");
       	response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();	

       	
       	String id = (String)session.getAttribute("id");
       	
       	String categoryId = request.getParameter("categoryId");
       	String title = request.getParameter("title");
       	String author = request.getParameter("author");
       	String summary = request.getParameter("summary");
       	String newscontent = request.getParameter("newscontent");
       	String picPath = request.getParameter("picPath");
       	
       	
       	Date date1 = new Date();
       	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
       	String date = dateformat.format(date1);
       	Date date2 = null;
		try {
			date2 = dateformat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
       	
       	News_detail news = new News_detail();
       	
       	news.setAuthor(author);
       	news.setCategoryid(Integer.parseInt(categoryId));
       	news.setTitle(title);
       	news.setContent(newscontent);
       	news.setSummary(summary);
       	news.setPicpath(picPath);
       	news.setCreatedate(date2);
       	news.setModifydate(date2);
       	
       	News_detailDao newsdao = new News_detailsDaoimpl();
       	boolean flag =  newsdao.updateNews(news, Integer.parseInt(id));
       	if (flag){
       	response.sendRedirect("index?page_1=1");
       	
       	}else{
       	 request.getRequestDispatcher("update.jsp").forward(request, response);
       	}

	
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
