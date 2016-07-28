<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String stuNo = (String)session.getAttribute("student");
%>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
	<meta charset="UTF-8">
	<title>修改个人信息</title>
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
		out.print("<p align='center'>请登录后再修改个人信息！<a href='login.jsp'>登录页面</a></p>");
	}else{
%>	
		<form action="<%= request.getContextPath() %>/ChangeInfoServlet" method="post">
			<div class="input_text">
				<span style="color:#000; font-size:24px;">学号：<%= stuNo %></span>
				<input type="hidden" name="stuNo" value="<%= stuNo %>" />
				<input type="password" name="password" class="inputbox" placeholder="密码" />
				<input type="text" name="name" class="inputbox" placeholder="姓名" />
				<input type="text" name="email" class="inputbox" placeholder="邮箱" />
				<input type="text" name="phone" class="inputbox" placeholder="手机" />
			</div>
			<div class="radio">
				<label>
					<span>性别</span>
					<input type="radio" name="sex" value="0" /><span>女</span>
					<input type="radio" name="sex" value="1" checked="checked" /><span>男</span>
				</label>
			</div>
			<div class="birthday">
				<span>生日
					<select class="selectbox" title="年" id="year" name="birthday_year">
						<option selected="1" value="0">年</option>
						<option value="2016">2016</option>
						<option value="2015">2015</option>
						<option value="2014">2014</option>
						<option value="2013">2013</option>
						<option value="2012">2012</option>
						<option value="2011">2011</option>
						<option value="2010">2010</option>
						<option value="2009">2009</option>
						<option value="2008">2008</option>
						<option value="2007">2007</option>
						<option value="2006">2006</option>
						<option value="2005">2005</option>
						<option value="2004">2004</option>
						<option value="2003">2003</option>
						<option value="2002">2002</option>
						<option value="2001">2001</option>
						<option value="2000">2000</option>
						<option value="1999">1999</option>
						<option value="1998">1998</option>
						<option value="1997">1997</option>
						<option value="1996">1996</option>
						<option value="1995">1995</option>
						<option value="1994">1994</option>
						<option value="1993">1993</option>
						<option value="1992">1992</option>
						<option value="1991">1991</option>
						<option value="1990">1990</option>
						<option value="1989">1989</option>
						<option value="1988">1988</option>
						<option value="1987">1987</option>
						<option value="1986">1986</option>
						<option value="1985">1985</option>
						<option value="1984">1984</option>
						<option value="1983">1983</option>
						<option value="1982">1982</option>
						<option value="1981">1981</option>
						<option value="1980">1980</option>
						<option value="1979">1979</option>
						<option value="1978">1978</option>
						<option value="1977">1977</option>
						<option value="1976">1976</option>
						<option value="1975">1975</option>
						<option value="1974">1974</option>
						<option value="1973">1973</option>
						<option value="1972">1972</option>
						<option value="1971">1971</option>
						<option value="1970">1970</option>
						<option value="1969">1969</option>
						<option value="1968">1968</option>
						<option value="1967">1967</option>
						<option value="1966">1966</option>
						<option value="1965">1965</option>
						<option value="1964">1964</option>
						<option value="1963">1963</option>
						<option value="1962">1962</option>
						<option value="1961">1961</option>
						<option value="1960">1960</option>
						<option value="1959">1959</option>
						<option value="1958">1958</option>
						<option value="1957">1957</option>
						<option value="1956">1956</option>
						<option value="1955">1955</option>
						<option value="1954">1954</option>
						<option value="1953">1953</option>
						<option value="1952">1952</option>
						<option value="1951">1951</option>
						<option value="1950">1950</option>
						<option value="1949">1949</option>
						<option value="1948">1948</option>
						<option value="1947">1947</option>
						<option value="1946">1946</option>
						<option value="1945">1945</option>
						<option value="1944">1944</option>
						<option value="1943">1943</option>
						<option value="1942">1942</option>
						<option value="1941">1941</option>
						<option value="1940">1940</option>
						<option value="1939">1939</option>
						<option value="1938">1938</option>
						<option value="1937">1937</option>
						<option value="1936">1936</option>
						<option value="1935">1935</option>
						<option value="1934">1934</option>
						<option value="1933">1933</option>
						<option value="1932">1932</option>
						<option value="1931">1931</option>
						<option value="1930">1930</option>
						<option value="1929">1929</option>
						<option value="1928">1928</option>
						<option value="1927">1927</option>
						<option value="1926">1926</option>
						<option value="1925">1925</option>
						<option value="1924">1924</option>
						<option value="1923">1923</option>
						<option value="1922">1922</option>
						<option value="1921">1921</option>
						<option value="1920">1920</option>
						<option value="1919">1919</option>
						<option value="1918">1918</option>
						<option value="1917">1917</option>
						<option value="1916">1916</option>
						<option value="1915">1915</option>
						<option value="1914">1914</option>
						<option value="1913">1913</option>
						<option value="1912">1912</option>
						<option value="1911">1911</option>
						<option value="1910">1910</option>
						<option value="1909">1909</option>
						<option value="1908">1908</option>
						<option value="1907">1907</option>
						<option value="1906">1906</option>
						<option value="1905">1905</option>
					</select>
					<select class="selectbox" title="月" id="month" name="birthday_month">
						<option selected="1" value="0">月</option>
						<option value="01">1 月</option>
						<option value="02">2 月</option>
						<option value="03">3 月</option>
						<option value="04">4 月</option>
						<option value="05">5 月</option>
						<option value="06">6 月</option>
						<option value="07">7 月</option>
						<option value="08">8 月</option>
						<option value="09">9 月</option>
						<option value="10">10 月</option>
						<option value="11">11 月</option>
						<option value="12">12 月</option>
					</select>
					<select class="selectbox" title="日" id="day" name="birthday_day">
						<option selected="1" value="0">日</option>
						<option value="01">1</option>
						<option value="02">2</option>
						<option value="03">3</option>
						<option value="04">4</option>
						<option value="05">5</option>
						<option value="06">6</option>
						<option value="07">7</option>
						<option value="08">8</option>
						<option value="09">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
					</select>
				</span>
			</div>
			<div class="job">
				<select name="job" id="job" class="inputbox">
					<option value="0">班长</option>
					<option value="1">学习委员</option>
					<option value="2">党委/团委</option>
					<option value="3">课代表</option>
					<option value="4">生活委员/体育委员</option>
					<option value="5" selected="selected">无职务</option>
				</select>
			</div>
			<div class="submit">
				<input type="submit" id="submit" class="button" value="修改" onclick="return checkChangeInfo()" />
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
	<script type="text/javascript" src="js/changeInfo.js"></script>
</body>
</html>