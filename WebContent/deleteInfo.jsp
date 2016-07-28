<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String stuNo = (String)session.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>删除个人信息</title>
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
		out.print("<p align='center'>请登录后再删除个人信息！<a href='login.jsp'>登录页面</a></p>");
	}else{
%>		
		<p style="text-align:center; font-size:24px; color:red;">警告！！！<br />删除个人信息后数据库中将不再保存您的所有信息！！！<br />您之前的留言也将被一并删除！！！</p>
		<form action="<%= request.getContextPath()%>/DelAllServlet" method="post">
			<textarea rows="9" cols="56" name="delReanson" class="inputbox" placeholder="请输入您要删除信息的原因" /></textarea>
			<div>
				<input type="submit" id="submit" class="button " value="删除" onclick="return confirm('确定要删除吗？');"/>
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