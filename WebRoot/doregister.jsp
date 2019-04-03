<%@page import="com.kjl.entity.News_user"%>
<%@page import="com.kjl.dao.impl.News_userDaoimpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doregister.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>s
  <%
    	   /*  request.setCharacterEncoding("utf-8");
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
          	
          	boolean flag=news.add(newsuser);
          	if(flag){
          	response.sendRedirect("login.jsp");
          	
         	}else{
          	request.getRequestDispatcher("register.jsp").forward(request, response);
           	}
          	
          	
          	 */
   %>
  
  
  </body>
</html>
