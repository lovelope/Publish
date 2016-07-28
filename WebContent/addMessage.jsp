<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String stuNo = (String)session.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>添加留言</title>
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
			<a href="stuInfo.jsp" title="个人信息">
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
		out.print("<p align='center'>请登录后再添加留言！<a href='login.jsp'>登录页面</a></p>");
	}else{
%>		
		<form action="<%= request.getContextPath()%>/AddMessageServlet" method="post">
			<input type="text" name="title" class="inputbox" placeholder="标题" />
			<textarea rows="9" cols="56" name="content" class="inputbox" placeholder="内容" /></textarea>
			<div>
				<input type="submit" id="submit" class="button " value="留言" />
				<input type="reset" id="reset" class="button " value="重置" />
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