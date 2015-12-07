<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page  isELIgnored="false"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="../static/css/application.css" rel="stylesheet">
<script src="../static/js/application.js"></script>
<script src="../static/js/jquery-1.11.0.js"></script>
</head>
<body>



<table  width="100%" border="1" cellpadding="0" cellspacing="1" class="tableLine DoubleColorTable" >
	
		<tr>
			<td colspan="3" align="center" class="tableLineBg">用户列表</td>
		</tr>
		<tr>
			<td>昵称</td>
			<td>手机</td>
			<td>邮箱</td>
		</tr>
		<c:forEach var="u" items="${list}">
		  <tr>
			<td>${u.nickname}</td>
			<td>${u.mobile}</td>
			<td>${u.email}</td>
		  </tr>
		</c:forEach>
				
	</table>
</body>
</html>
