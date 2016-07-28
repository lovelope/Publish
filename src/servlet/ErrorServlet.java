package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = -6334039867539676102L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		Integer status_code = (Integer) request.getAttribute("javax.servlet.error.status_code");

		out.println("<html><head><title>这个页面找不到了呢</title><style>*{text-align:center;font-size:36px;}</style></head>");
		out.println("<body>");
		switch (status_code) {
		case 401:
			break;
		case 404:
			out.println("<h2 style='font-size:48px;margin-top:300px;'>HTTP 状态码: " + status_code + "</h2>");
			out.println("这个页面已经被删除或者页面名被更改。<br />");
			out.println("<a href='mailto:lovelope@qq.com'>联系管理员</a>");
			break;
		default:
			break;
		}
		out.println("</body></html>");
		out.close();
	}

}
