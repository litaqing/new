<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.kjl.entity.News_detail"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
	<head>
		<link href="<%=request.getContextPath() %>/css/common.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
       function back(){
        window.location.href="index.jsp?page_1=1";
   
        }
    </script>
	</head>
	
	<%
	
	  News_detail news = new News_detail();
	  
	  String ids = request.getParameter("id");
	  
	  session.setAttribute("id", ids);
	
	 %>
<body>
<form name ="dataFrm" id="dataFrm" action="adminNewsCreate" method="post">
	<table  width="100%" border="0" cellspacing="5" cellpadding="0">
		<thead>
			<tr><td align="center" colspan="2" class="text_tabledetail2">修改新闻</td></tr>
		</thead>
		<tbody>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">分类</td>
				<td style="text-align:left;">
				<!-- 列出所有的新闻分类 -->
					<select name="categoryId">
	        			<option value="1">国内</option>
	        			<option value="2">国际</option>
	        			<option value="3">娱乐</option>
	        			<option value="4">军事</option>
	        			<option value="5">财经</option>
	        			<option value="6">天气</option>
	        		</select>
				</td>
			</tr>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">标题</td>
				<td style="text-align:left;"><input type="text" name="title" value=""/></td>
			</tr>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">作者</td>
				<td style="text-align:left;"><input type="text" name="author" value=""/></td>
			</tr>
			
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">摘要</td>
				<td style="text-align:left;"><textarea id="summary" name="summary" rows="8" cols="50"></textarea></td>
			</tr>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">内容</td>
				<td style="text-align:left;">
				<div id="xToolbar"></div>
				<textarea id="newscontent" name="newscontent" rows="8" cols="30"></textarea></td>
			</tr>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">上传图片 </td>
				<td style="text-align:left;"><input type="text" name="picPath" value=""/></td>
			</tr>
			<tr>
				<td style="text-align:center;" colspan="2">
					<button type="submit" class="page-btn" name="save" style="width: 20px">确认修改</button>
					<button type="button" class="page-btn" name="return" onclick="back()" style="size: 25px">返回</button>
				</td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>