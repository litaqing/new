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
    
    <title>My JSP 'dologin.jsp' starting page</title>
    
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
                request.setCharacterEncoding("UTF-8");
         		response.setCharacterEncoding("utf-8");
         		String user = request.getParameter("username");
         		String pwd = request.getParameter("pwd");
         		
         		
         		
         			//用户输入的
         		/* String vCode = request.getParameter("verify");
         		//生成的
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
				}        */  		
         		
         		News_userDaoimpl newsuser = new News_userDaoimpl();
         		News_user users = newsuser.findByUser(user, pwd);
         		
         		
         		 
         		if(users!=null){
  			
  			     session.setAttribute("username", user);//浏览器与服务器的一会话
  			    //重定向
  			    response.sendRedirect("index.jsp"); 
         		 
         		} else{
         		 request.setAttribute("message", "用户名或密码有误！！！");
  			     //转发
  			     request.getRequestDispatcher("login.jsp").forward(request, response);
         		
         		}
         		 
         		 %>
  
  </body>
</html>
