package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Message;
import service.AddMessageService;

public class AddMessageServlet extends HttpServlet {

	private static final long serialVersionUID = 5304784063398442563L;

	private AddMessageService addMsg = new AddMessageService();

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

		HttpSession session = request.getSession();
		String stuNo = (String)session.getAttribute("student");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// System.out.println("==========================" + stuNo +
		// "==========================");
		// System.out.println("==========================" + title +
		// "==========================");
		// System.out.println("==========================" + content +
		// "==========================");

		RequestDispatcher rd = null;
		String forward = null;

		Message msg = new Message();

		msg.setStuNo(stuNo);
		msg.setTitle(title);
		msg.setContent(content);
		msg.setTime();

		// System.out.println("==========================" + msg.toString() +
		// "==========================");

		boolean bool = addMsg.add(msg);
		if (bool) {// 留言成功
			request.setAttribute("msg", "恭喜您留言成功，请查看！");
			forward = "message.jsp";
		} else {// 留言失败
			request.setAttribute("msg", "留言失败，请重新留言！");
			forward = "error.jsp";
		}

		rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
}
