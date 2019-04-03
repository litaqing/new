<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<link rel="stylesheet" href="css/common.css" type="text/css"></link>
<script type="text/javascript">
   function addNews(){
     window.location.href="addNews.jsp";
   
   }
</script>
  <div class="main-content-right">
        <!--即时新闻-->
        <div class="main-text-box">
            <div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
				<form name="searchForm" id="searchForm"
					action="index" method="post">
					<div>
						新闻分类：
							 <select name="categoryId" >
								<option value="0">全部</option>
								<option value='1'>国内</option>
								<option value='2'>国际</option>
								<option value='3'>娱乐</option>
								<option value='4'>军事</option>
								<option value='5'>财经</option>
								<option value='6'>天气</option>
							</select> 
						新闻标题<input type="text" name="title" id="title" value='${title }' />
						<button type="submit" class="page-btn">GO</button>
						<button type="button" onclick="addNews();" class="page-btn" style="width: 50px">增加</button>
						<input type="hidden" name="pageIndex" id="pageIndex" /> 
						<input type="hidden" name="page_1" value="3"/> 
						<input type="hidden" name="totalPageCount" id="totalPageCount" value="${pages.pageCount }" />
					</div>
				</form>
				<table  class="admin-list">	
				<thead >
					<tr class="admin-list-head">
						<th>新闻标题</th>
						<th>新闻分类</th>
                        <th>作者</th>
                        <th>时间</th>
                        <th>操作</th>
                    </tr>
                </thead>
               		
                <tbody>
                	<c:forEach items="${pages.pageList }" var="news" varStatus="v">
                		<c:if test="${v.index % 2==0 }">
                			<tr class="admin-list-td-h1">
                		</c:if>
                		<c:if test="${v.index % 2!=0 }">
                			<tr class="admin-list-td-h2">
                		</c:if>
                			
                		<td align="left"><a href='adminNewsView.jsp?id=2'>${news.title }</a></td>
                		<td>${news.cate.name }</td>
                		<td>${news.author }</td>
                		<td><fmt:formatDate value="${news.createdate }" pattern="yyyy-MM-dd"/> </td>
                		<td><a href=" update.jsp?id=${news.id} ">修改</a>
                			<a href="javascript:if(confirm('确认是否删除此新闻？')) location='adminNewsDel?id=${news.id} ' ">删除</a>
                		</td>
                	</c:forEach>
                </tbody>
            </table>
           <c:import url="rollpage.jsp">
           		<c:param name="pageCount" value="${pages.pageCount}"/>
           		<c:param name="currentPageNo" value="${pages.curPageNo}"/>
           		<c:param name="totalCount" value="${pages.rowCount}"/>
           </c:import>
        </div>
       </div>
   </div>
   </div>
