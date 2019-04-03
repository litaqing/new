package com.kjl.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kjl.dao.News_detailDao;
import com.kjl.dao.impl.News_detailsDaoimpl;
import com.kjl.entity.News_detail;
import com.kjl.utils.PageBeanSQL;

public class Index extends HttpServlet {

	public Index() {
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
		   request.setCharacterEncoding("UTF-8");	
			HttpSession session = request.getSession();	

			String curPageNo = request.getParameter("pageIndex");
			String title = request.getParameter("title");
			String cid = request.getParameter("categoryId");
			String page_1 = request.getParameter("page_1");
			
			if(curPageNo == null||curPageNo==""){
				curPageNo = "1";
			}
			News_detailDao dao = new News_detailsDaoimpl();
			
    	PageBeanSQL<News_detail> pages = null;
		try {
			pages = dao.getPagesByListNews(curPageNo, title, cid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
			session.setAttribute("pages", pages);
			request.setAttribute("title", title);
			request.setAttribute("cid", cid);

		if(page_1 != null){
			request.getRequestDispatcher("newsDetailList.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
		
		 


	}


	public void init() throws ServletException {
		// Put your code here
	}

}
