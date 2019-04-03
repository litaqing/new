<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'rollpage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  
  	function jump_to(frm,index){
  		
  		var regexp = /^\d*$/;
  		
  		var totalPageCount = document.getElementById("totalPageCount").value;
  		if(!regexp.test(index)){
  			alert("输入大于0的数字！");
  			return false;
  		}else if((index-totalPageCount) > 0){
  			alert("请输入小于总页数的页码！！");
  			return false;
  		}
  		
  		page_nav(frm,index);
  		
  	};
  	function page_nav(frm,index){
  		//alert(index);
  		frm.pageIndex.value = index;
  		
  		frm.submit();
  	}
  </script>
  <body>
  <!--
  <c:param name="pageCount" value="${pages.pageCount}"/>
           		<c:param name="currentPageNo" value="${pages.curPageNo}"/>
           		<c:param name="totalCount" value="${pages.rowCount}"/>
    -->
     <div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共${param.totalCount }条记录&nbsp;&nbsp; ${param.currentPageNo }/${param.pageCount }页
				<a href="javascript:page_nav(document.forms[0],1);">首页</a>
				<a href="javascript:page_nav(document.forms[0],${param.currentPageNo-1 });">上一页</a>
				<a href="javascript:page_nav(document.forms[0],${param.currentPageNo+1 });">下一页</a>
				<a href="javascript:page_nav(document.forms[0],${param.pageCount });">尾页</a>
				</li>
			</ul>
		 <span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key" />页
	     <button type="button" class="page-btn" onclick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
		</span>
		</div> 
  </body>
</html>
