<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String stuNo = (String)session.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>主页</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">	
</head>
<body>

	<main>
		<h1>班级信息发布系统</h1>
<%
	if(stuNo == null){
		out.print("<p align='center'>请登录后再进入此页面！<a href='login.jsp'>登录页面</a></p>");
	}else{
%>		
		<ul>
			<li><a href="message.jsp">查看留言</a></li>
			<li><a href="addMessage.jsp">添加留言</a></li>
			<li><a href="stuInfo.jsp">学生信息</a></li>
			<li><a href="changeInfo.jsp">修改信息</a></li>
			<li><a href="deleteInfo.jsp">删除信息</a></li>
			<li><a href="search.jsp">查询学生</a></li>
		</ul>
<%
	}
%>
	</main>
	<footer>
		<p>2016&copy;<a href="http://www.xidian.edu.cn" target="_blank">西安电子科技大学</a></p>
	</footer>
</body>
</html>