package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import service.CheckUserService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -154176561953216931L;
	private CheckUserService cku = new CheckUserService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuNo = request.getParameter("stuNo");
		String passwd = request.getParameter("password");		
		
		RequestDispatcher rd = null;
		String forward = null;
		
		if(stuNo == null || passwd == null){
			request.setAttribute("msg", "学号或密码为空！");
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}else{
			User user = new User();
			user.setStuNo(stuNo);
			user.setPassword(passwd);
			boolean bool = cku.check(user);
			
			if(bool){
				HttpSession session = request.getSession();
				session.setAttribute("student", stuNo);
				forward = "index.jsp";
			}else{
				request.setAttribute("msg", "学号或密码输入错误，请重新输入！");
				forward = "error.jsp";
			}
			
			rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}
	}
}
