<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<link rel="stylesheet" href="css/common.css" type="text/css"></link>

<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!-- <link rel="stylesheet" type="text/css" href="styles.css"> -->
<script type="text/javascript">
	function register() {
		window.location.href = "register.jsp";
	}
	function change() {
		var vcode = document.getElementById("verifycode");
		vcode.src = "verifycode.jsp?magic=" + new Date().getTime();
	}
	;
</script>
</head>

<body>
	<div id="title" align="center">用户登录</div>
	<form action="dologin" method="post" name="myform"
		onsubmit="return chcek()">
		<div class="div_1" align="center">
			<ul>
				<li>用户姓名： <input name="username" type="text">
				</li>
				<li>用户密码： <input name="pwd" type="text">
				</li>
			</ul>
		</div>
		<div align="center">
			输入验证码： <input name="verify" type="text"> <img alt=""
				src="verifycode.jsp" id="verifycode" border="2px"> <a
				href="javascript:change()">换一张</a>${errors }

		</div>
		<div align="center">
			<input type="submit" value="登录">&nbsp;&nbsp; <input
				type="button" value="注册" onclick="register()">
		</div>

	</form>

	<div align="center" style="color: red;">
		<%
			Object meg = request.getAttribute("message");
		%>
		<%=meg == null ? "" : meg%>
	</div>

</body>
</html>