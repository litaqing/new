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

import com.kjl.dao.impl.News_detailsDaoimpl;
import com.kjl.entity.News_detail;

public class AddNews extends HttpServlet {

	public AddNews() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
         
         String categoryId = request.getParameter("categoryId");
         String title = request.getParameter("title");
         String author = request.getParameter("author");
         String summary = request.getParameter("summary");
         String newscontent = request.getParameter("newscontent");
         String picPath = request.getParameter("picPath");
         Date date1 = new Date();
         SimpleDateFormat datefomat = new SimpleDateFormat("yyyy-MM_dd");
         String  date= datefomat.format(date1);
         Date date2=null;
		try {
			date2 = datefomat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        News_detailsDaoimpl newsdao = new News_detailsDaoimpl();
         
        News_detail news = new News_detail(Integer.parseInt(categoryId),title,author,summary,newscontent,picPath,date2,date2);
         boolean flag =  newsdao.addnews(news);

         if (flag){
           response.sendRedirect("index?page_1=1");
         }else {
           request.getRequestDispatcher("addNews.jsp").forward(request, response);
         }
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
