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
	<title>学生信息</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
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
		out.print("<p align='center'>请登录后查看同学信息！<a href='login.jsp'>登录页面</a></p>");
	}else{

		//把经常需要修改的数据放在最上面，以方便修改
		String username="myuser";//数据库用户名
		String password="mypassword";//数据库密码
	
		//jsp程序中半数以上的Exception是NonePointerException,在声明变量时赋予一个初始值，能缩短调试时间
		ResultSet rs=null;//数据库查询结果集
		Connection conn=null;
		Statement stmt=null;
		
		//注册驱动程序
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(java.lang.ClassNotFoundException e)
		{
			System.err.println("Driver Error"+e.getMessage());
		}
		
		//连接数据库并创建Statement对象
		String url="jdbc:mysql://localhost:3306/publish?useUnicode=true&characterEncoding=utf-8&useSSL=true";
		try
		{
			conn=DriverManager.getConnection(url,username,password);
			stmt=(Statement)conn.createStatement();
		}catch(Exception e)
		{
			System.err.println("数据库连接错误:"+e.getMessage());
		}
		
		//通过Statement执行SQL语句来获取查询结果
		try
		{
			rs=(ResultSet)stmt.executeQuery("select * from student");
		}catch(SQLException ex)
		{
			System.err.println("数据库查错误:"+ex);
		}
%>

<table width="100%" border="0" align="center">
  <tr style="background-color:#ccc;">
     <td>学号</td>
     <td>姓名</td>
     <td>性别</td>
     <td>生日</td>
     <td>手机</td>
     <td>邮箱</td>
     <td>职务</td>
  </tr>
 
<%
	//利用while循环输出各条记录
	while( rs.next() ){
%>
<tr>
	<td><%=rs.getString("stuNo") %></td>
	<td><%=rs.getString("name") %></td>
	<td><%=((rs.getInt("sex") == 1 ) ? "男" : "女") %></td>
	<td><%=rs.getString("birthday") %></td>
	<td><%=rs.getString("phone") %></td>
	<td><%=rs.getString("email") %></td>
	<td>
	<%
		int job = rs.getInt("job");
		if(job == 0){
			out.print("班长");
		}else if(job == 1){
			out.print("学习委员");
		}else if(job == 2){
			out.print("党委/团委");
		}else if(job == 3){
			out.print("课代表");
		}else if(job == 4){
			out.print("生活委员/体育委员");
		}else{
			out.print("无职务");
		}
	%>
	</td>
</tr>
<%
	}
%>
</table>
<%
		rs.close();
		stmt.close();
		conn.close();
	}
%>
	</main>
	<footer>
		<p>2016&copy;<a href="http://www.xidian.edu.cn" target="_blank">西安电子科技大学</a></p>
	</footer>
</body>
</html>