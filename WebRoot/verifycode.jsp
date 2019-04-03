<%@page import="java.awt.image.BufferedImage"%>
<%@page import="com.kjl.utils.VerifyCode"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'verifycode.jsp' starting page</title>
    
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
     
  		VerifyCode verify = new VerifyCode();
  		//得到验证码图片
  		BufferedImage image = verify.getImage();
  		
  		session.setAttribute("session_verifyCode", verify.getText());
  		
  		out.clearBuffer();
  		out = pageContext.pushBody();
  		
  		//把图片响应到客户端
  		verify.output(image, response.getOutputStream());
  
   %>
  </body>
</html>
