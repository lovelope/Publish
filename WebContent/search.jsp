<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.io.*,java.util.*,java.sql.SQLException" %>
<%@ page import="util.*,dao.impl.*" %>
<%
	String stuNo = (String)session.getAttribute("student");
%>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
	<meta charset="UTF-8">
	<title>查询学生信息</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<link rel="stylesheet" type="text/css" href="css/message.css">
</head>
<body>
	<header>
		<div class="logo">
			<a href="index.jsp"><img src="img/HOME.jpg" alt="主页" /></a>
		</div>
		<div class="title">
			<h1><a href="index.jsp">班级信息发布系统</a></h1>
		</div>
		<div class="info">
			<a href="stuInfo.jsp" title="同学信息">
				<img src="img/tower.png" alt="用户头像" />
				<span id="user"><%= stuNo %></span>
			</a>
		</div>
		<div class="exit">
			<input type="button" value="注销" onclick="javascript:window.location.href='logout.jsp'" />
		</div>
	</header>
	<main>
<%
	if(stuNo == null){
		out.print("<p align='center'>请登录后查询同学信息！<a href='login.jsp'>登录页面</a></p>");
	}else{
%>
	<form action="<%= request.getContextPath() %>/SearchServlet" method="post">
		<div class="radio">
			<label>
				<span>查询类型</span>
				<input type="radio" name="type" value="0" checked="checked" /><span>学号</span>
				<input type="radio" name="type" value="1" /><span>姓名</span>
			</label>
		</div>
		<div class="input_text">
			<input type="text" name="content" class="inputbox" placeholder="要查询的内容" />
		</div>
		<div class="submit">
			<input type="submit" id="submit" class="button" value="查询" />
			<input type="reset" id="reset" class="button" value="重置" />
		</div>
	</form>
<%
	}
%>
	</main>
	<footer>
		<p>2016&copy;<a href="http://www.xidian.edu.cn" target="_blank">西安电子科技大学</a></p>
	</footer>
</body>
</html>