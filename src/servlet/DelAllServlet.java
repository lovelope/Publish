package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DelAllService;

public class DelAllServlet extends HttpServlet {

	private static final long serialVersionUID = 4503425557432553230L;

	private DelAllService delAll = new DelAllService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(
				"utf-8");/* 设置request对象的字符编码为UTF-8，可以使中文不乱码（很重要） */

		String stuNo = request.getParameter("stuNo");
		String delReason = request.getParameter("delReason");

		System.out.println("==========================" + stuNo + ":" + delReason + "==========================");

		RequestDispatcher rd = null;
		String forward = null;

		boolean bool = delAll.delAll(stuNo);// 修改信息
		if (bool) {// 删除所有个人信息成功
			request.setAttribute("msg", "恭喜您删除个人信息成功，再见！");
			forward = "success.jsp";
		} else {// 删除所有个人信息失败
			request.setAttribute("msg", "删除个人信息失败，请重新删除！");
			forward = "error.jsp";
		}

		rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	/*
	 * @Override public void destroy() { super.destroy(); }
	 * 
	 * @Override public void init() throws ServletException {
	 * 
	 * }
	 * 
	 * @Override protected void service(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { //
	 * TODO Auto-generated method stub super.service(request, response); }
	 */
}
