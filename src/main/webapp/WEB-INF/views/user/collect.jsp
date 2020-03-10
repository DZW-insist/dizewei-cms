<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	
	<h3>我的收藏夾</h3>
	<hr style="height:3px;border:none;border-top:3px double red;" />
	
	<form id="queryForm">
		<input type="text" name="text">
		<input type="hidden" id="pageNum" name="pageNum" value="${pageInfo.pageNum }">
		<button type="button" class="btn btn-primary mb-2" onclick="query();">查询</button>
	</form>
	1111
	<ul>
		<c:forEach items="${pageInfo.list }" var="item" varStatus="status">
		  	<li>
		  		<div class="media">
				  <div class="media-body">
				    <h4 class="mt-1">
				    	<a href="${item.url}" target="_blank">${item.text }</a>
				    </h4>
				    <p style="color: #999;">${item.url } <fmt:formatDate value="${item.created }" pattern="yyyy-MM-dd HH:mm:ss"/></p>
				  </div>
				</div>
				<button type="button" class="btn btn-primary" onclick="del();">确认删除</button>
		  	</li>
		</c:forEach>
	</ul>
	<jsp:include page="../common/page.jsp"></jsp:include>
		<script type="text/javascript">
		
		
		function query(){
			var params = $("#queryForm").serialize();
			reload(params)
		}
		
		function gotoPage(pageNum){
			$("#pageNum").val(pageNum);
			query();
		}
		
	</script>
