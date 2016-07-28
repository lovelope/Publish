/*验证学号密码是否输入正确*/
function checkLogin() {
	/*正则表达式*/
	var regStuNo = /^[1-9][0-9]{10}$/,
		regPasswd = /^[A-Za-z0-9\!\@\#\$\%\^\&\*\.\~]{6,22}$/;
	/*按name获取元素*/
	var stuNo = document.getElementsByName("stuNo")[0],
		passwd = document.getElementsByName("passwd")[0];

	if(!regStuNo.test(stuNo.value)){
		alert("学号为首位不为0的11位的数字");
		stuNo.focus();
		return false;
	}
	if(!regPasswd.test(passwd.value)){
		alert("密码为6~22位的数字英文字母或符号");
		passwd.focus();
		return false;
	}
	return true;
}
