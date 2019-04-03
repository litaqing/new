<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
    function login(){
    window.location.href="login.jsp";
    
    }


</script>
  </head>
  
  <body>
  <div align="center">
  <font  color="red" size="20px">用户注册</font>
  </div>
  <div align="center">
    <form action="doregister">
       用户姓名：<input name="user" type="text"><br> 
       用户密码：<input name="pwds" type="text"><br>
       用户邮箱：<input name="email" type="text"><br>
       用户类型: <input name="usertype" type="radio" value="0">管理员
    			 <input name="usertype" type="radio" value="1">普通用户
    <div align="center">
   			<input type="submit" value="提交注册">&nbsp;&nbsp;
   			<input type="button" value="返回登录" onclick="login()">
   		</div>	
   </form>
   </div>
  </body>
</html>
