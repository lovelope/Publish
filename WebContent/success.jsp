<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>成功提示信息</title>
	<style type="text/css">
		body{
			color:#000;
			font-size:18px;
			margin: 20px auto;
		}
		#message{
			text-align:center;
		}
	</style>
</head>
<body>
	<div id="message">
		操作成功！<br />
		提示：
		<%
			Object obj = request.getAttribute("msg");
			if(obj != null){
				out.print(obj.toString());
			}else{
				out.println("无");
			}
		%>
		<br>
		<a href="<%= request.getContextPath()%>/login.jsp">返回登陆页面</a>
	</div>
</body>
</html>