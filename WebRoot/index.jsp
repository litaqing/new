<%@page import="com.kjl.entity.News_detail"%>
<%@page import="com.kjl.utils.PageBeanSQL"%>
<%@page import="com.kjl.dao.impl.News_detailsDaoimpl"%>
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
    
    <title>My JSP 'index.jsp' starting page</title>
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
  	
    		/* request.setCharacterEncoding("UTF-8");	
    		
  			String curPageNo = request.getParameter("pageIndex");
  			String title = request.getParameter("title");
  			String cid = request.getParameter("categoryId");
  			String page_1 = request.getParameter("page_1");
  			
  			if(curPageNo == null||curPageNo==""){
  				curPageNo = "1";
  			}
  			News_detailDao dao = new News_detailsDaoimpl();
  			
        	PageBeanSQL<News_detail> pages = dao.getPagesByListNews(curPageNo, title, cid);
        	
  			session.setAttribute("pages", pages);
  			request.setAttribute("title", title);
  			request.setAttribute("cid", cid);
    
    		if(page_1 != null){
    			request.getRequestDispatcher("newsDetailList.jsp").forward(request, response);
    		}else{
    			request.getRequestDispatcher("admin.jsp").forward(request, response);
    		}
    		
    		  */
    
    
    
     %>
  </body>
</html>
