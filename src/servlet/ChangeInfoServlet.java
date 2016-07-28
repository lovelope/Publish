package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.ChangeInfoService;
import validation.Validation;

public class ChangeInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 4503425557432553230L;

	private ChangeInfoService changeInfo = new ChangeInfoService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(
				"utf-8");/* 设置request对象的字符编码为UTF-8，可以使中文不乱码（很重要） */

		String stuNo = request.getParameter("stuNo");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String birthday_year = request.getParameter("birthday_year");
		String birthday_month = request.getParameter("birthday_month");
		String birthday_day = request.getParameter("birthday_day");
		String birthday = birthday_year + "-" + birthday_month + "-" + birthday_day;
		String job = request.getParameter("job");

		System.out.println("==========================" + stuNo + "==========================");
		System.out.println("==========================" + password + "==========================");
		System.out.println("==========================" + name + "==========================");
		System.out.println("==========================" + email + "==========================");
		System.out.println("==========================" + phone + "==========================");
		System.out.println("==========================" + sex + "==========================");
		System.out.println("==========================" + birthday + "==========================");
		System.out.println("==========================" + job + "==========================");

		RequestDispatcher rd = null;
		String forward = null;

		if (!Validation.MatchPassword(password)) {
			request.setAttribute("msg", "您输入的密码不合法！");
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		} else if (!Validation.MatchName(name)) {
			request.setAttribute("msg", "您输入的姓名不合法！");
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		} else if (!Validation.MatchEmail(email)) {
			request.setAttribute("msg", "您输入的邮箱不合法！");
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		} else if (!Validation.MatchPhone(phone)) {
			request.setAttribute("msg", "您输入的手机号码不合法！");
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		} else if (!Validation.MatchBirthday(birthday)) {
			request.setAttribute("msg", "您输入的生日不合法！");
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		} else if (!Validation.MatchSex(sex)) {
			request.setAttribute("msg", "您输入的性别不合法！");
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		} else if (!Validation.MatchJob(job)) {
			request.setAttribute("msg", "您输入的职务不合法！");
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}

		else {
			User user = new User();

			user.setStuNo(stuNo);
			user.setPassword(password);
			user.setName(name);
			user.setEmail(email);
			user.setPhone(phone);
			user.setSex(sex);
			user.setJob(job);

			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date utilDate = sdf.parse(birthday); // 先把字符串转为util.Date对象
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // 再转换为sql.Date对象
				user.setBirthday(sqlDate);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("==========================" + user.toString() + "==========================");

			boolean bool = changeInfo.changeInfo(stuNo, user);// 修改信息
			if (bool) {// 修改成功
				request.setAttribute("msg", "恭喜您修改个人信息成功，请重新登录后查看新的个人信息！");
				forward = "success.jsp";
			} else {// 修改失败
				request.setAttribute("msg", "修改个人信息失败，请重新修改！");
				forward = "error.jsp";
			}

			rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}
	}
}
