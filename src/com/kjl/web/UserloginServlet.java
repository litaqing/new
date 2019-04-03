package com.kjl.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kjl.dao.impl.News_userDaoimpl;
import com.kjl.entity.News_user;

public class UserloginServlet extends HttpServlet {


	public UserloginServlet() {
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
		 request.setCharacterEncoding("UTF-8");
  		response.setCharacterEncoding("utf-8");
  		String user = request.getParameter("username");
  		String pwd = request.getParameter("pwd");
  		
  		
  		
  			//用户输入的
  		String vCode = request.getParameter("verify");
  		//生成的
		HttpSession session = request.getSession();	

  		String sCode = (String)session.getAttribute("session_verifyCode");
  		
  		
			if(vCode == null || vCode.trim().isEmpty()){
				request.setAttribute("errors", "验证码不能为空！");	
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return ;
			}         		
  		
  		if(!vCode.trim().equalsIgnoreCase(sCode)){
  			System.out.println("0000000000--->"+vCode+"---->"+sCode);
				request.setAttribute("errors", "验证码错误！");	
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return ;
			}         		
  		
  		News_userDaoimpl newsuser = new News_userDaoimpl();
  		News_user users = newsuser.findByUser(user, pwd);
  		
  		
  		 
  		if(users!=null){
		
		     session.setAttribute("username", user);//浏览器与服务器的一会话
		    //重定向
		    response.sendRedirect("index"); 
  		 
  		} else{
  		 request.setAttribute("message", "用户名或密码有误！！！");
		     //转发
		     request.getRequestDispatcher("login.jsp").forward(request, response);
  		
  		}
  		 

	}

	
	public void init() throws ServletException {
	}

}
