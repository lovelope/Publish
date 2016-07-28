<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
	<meta charset="UTF-8">
	<title>登录</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<main>
		<h1 id="loginH1">班级信息发布系统</h1>
		<form action="<%= request.getContextPath()%>/LoginServlet" method="post">
			<input type="text" name="stuNo" class="inputbox" placeholder="学号" />
			<input type="password" name="password" class="inputbox" placeholder="密码" />
			<div>
				<input type="submit" id="submit" class="button " value="登录" onclick="return checkLogin()" />
				<input type="reset" id="reset" class="button " value="重置" />
			</div>
			<div>
				<a href="register.jsp">注册</a>
			</div>
		</form>
	</main>
	<footer>
		<p>2016&copy;<a href="http://www.xidian.edu.cn" target="_blank">西安电子科技大学</a></p>
	</footer>
	<script type="text/javascript" src="js/login.js"></script>
</body>
</html>