package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	/**
	 * 正则验证方法
	 * 
	 * @param regexstr
	 * @param str
	 * @return
	 */
	public static boolean Match(String regexstr, String str) {
		Pattern regex = Pattern.compile(regexstr, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Matcher matcher = regex.matcher(str);
		return matcher.matches();
	}

	/**
	 * 学号验证
	 * 
	 * @param stuNo
	 * @return
	 */
	public static boolean MatchStuNo(String stuNo) {
		String stuNoregex = "^[1-9][0-9]{10}$";
		return Match(stuNoregex, stuNo);
	}

	/**
	 * 密码验证
	 * 
	 * @param password
	 * @return
	 */
	public static boolean MatchPassword(String password) {
		String passwordregex = "^[A-Za-z0-9\\!\\@\\#\\$\\%\\^\\&\\*\\.\\~]{6,22}$";
		return Match(passwordregex, password);
	}

	/**
	 * 学号验证
	 * 
	 * @param stuNo
	 * @return
	 */
	public static boolean MatchName(String name) {
		String nameregex = "^([\\u4e00-\\u9fa5]{2,4}|([a-zA-Z]+\\s?){1,30})$";
		return Match(nameregex, name);
	}

	/**
	 * 邮箱验证
	 * 
	 * @param mail
	 * @return
	 */
	public static boolean MatchEmail(String email) {
		String emailregex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		return Match(emailregex, email);
	}

	/**
	 * 手机验证
	 * 
	 * @param phone
	 * @return
	 */
	public static boolean MatchPhone(String phone) {
		String phoneregex = "^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";
		return Match(phoneregex, phone);
	}
	
	/**
	 * 日期验证
	 * 
	 * @param birthday
	 * @return
	 */
	public static boolean MatchBirthday(String birthday) {
		String birthdayregex = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$";
		return Match(birthdayregex, birthday);
	}
	
	/**
	 * 性别验证
	 * 
	 * @param sex
	 * @return
	 */
	public static boolean MatchSex(String sex) {
		String sexregex = "^[01]$";//女|男
		//String sexregex = "^女|男$";//女|男
		return Match(sexregex, sex);
	}
	
	/**
	 * 职务验证
	 * 
	 * @param job
	 * @return
	 */
	public static boolean MatchJob(String job) {
		String jobregex = "^[0-5]$";
		return Match(jobregex, job);
	}
	
}