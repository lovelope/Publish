/*验证学号密码是否输入正确*/
function checkChangeInfo() {
	/*正则表达式*/
	var regPasswd = /^[A-Za-z0-9\!\@\#\$\%\^\&\*\.\~]{6,22}$/,
		regName = /^([\u4e00-\u9fa5]{2,4}|([a-zA-Z]+\s?){1,30})$/,
		regEmail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})$/,
		regPhone = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
	/*按name获取元素*/
	var passwd = document.getElementsByName("passwd")[0],
		name = document.getElementsByName("name")[0],
		email = document.getElementsByName("email")[0],
		phone = document.getElementsByName("phone")[0],
		sex = document.getElementsByName("sex"),
		birthday_year = document.getElementById("year"),
		birthday_month = document.getElementById("month"),
		birthday_day = document.getElementById("day"),
		job = document.getElementsByName("job");


	if(!regPasswd.test(passwd.value)){
		alert("密码为6~22位的数字英文字母或符号");
		passwd.focus();
		return false;
	}
	if(!regName.test(name.value)){
		alert("姓名为2~4个汉字或1~30个英文字母");
		name.focus();
		return false;
	}
	if(!regEmail.test(email.value)){
		alert("邮箱填写错误");
		email.focus();
		return false;
	}
	if(!regPhone.test(phone.value)){
		alert("手机号码填写错误");
		phone.focus();
		return false;
	}
	if(birthday_year.value==0 || birthday_month==0 || birthday_day==0){
		alert("生日没有填写");
		return false;
	}
	return true;
}
