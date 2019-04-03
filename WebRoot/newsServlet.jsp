<%@page import="com.kjl.dao.impl.News_detailsDaoimpl"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.kjl.entity.News_detail"%>
<%@page import="com.kjl.dao.News_detailDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newsServlet.jsp' starting page</title>
    
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
      System.out.println("---------------------->>>>>"+path);
      System.out.println("------------------------>>>"+basePath);
       /* 	request.setCharacterEncoding("utf-8");
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
         Date date2=  datefomat.parse(date);
      
        News_detailsDaoimpl newsdao = new News_detailsDaoimpl();
         
        News_detail news = new News_detail(Integer.parseInt(categoryId),title,author,summary,newscontent,picPath,date2,date2);
         boolean flag =  newsdao.addnews(news);

         if (flag){
           response.sendRedirect("index.jsp?page_1=1");
         }else {
           request.getRequestDispatcher("addNews.jsp").forward(request, response);
         } */
       %>

  </body>
</html>
