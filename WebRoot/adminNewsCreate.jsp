<%@page import="com.kjl.dao.impl.News_detailsDaoimpl"%>
<%@page import="com.kjl.dao.News_detailDao"%>
<%@page import="com.kjl.entity.News_detail"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminNewsCreate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%
           /*  request.setCharacterEncoding("utf-8");
          	response.setCharacterEncoding("utf-8");
          	
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
          	Date date2 = dateformat.parse(date); 
          	
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
          	response.sendRedirect("index.jsp?page_1=1");
          	
          	}else{
          	 request.getRequestDispatcher("update.jsp").forward(request, response);
          	} */
  
   %>
  
  </body>
</html>
