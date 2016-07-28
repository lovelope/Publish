package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SearchService;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = -154176561953216931L;
	private SearchService search = new SearchService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int type = Integer.parseInt(request.getParameter("type"));
		String content = request.getParameter("content");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd = null;
		String forward = null;
		
		if(content == null){
			request.setAttribute("msg", "类型或内容为空！");
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}else{
			ResultSet rs = search.get(type, content);
			out.print("<!DOCTYPE html><html><head><meta charset='UTF-8'></head><body>"
					+ "<header><h1><a href='index.jsp'  text-align='center'>班级信息发布系统</a></h1></header>"
					+ "<main><table width='100%' border='0' align='center'>"
					+ "<tr style='background-color:#ccc;'>"
					+ "<td>学号</td><td>姓名</td><td>性别</td><td>生日</td><td>手机</td><td>邮箱</td><td>职务</td>"
					+ "</tr>");
			
			//利用while循环输出各条记录
			try {
				while( rs.next() ){
					out.print("<tr><td>" + rs.getString("stuNo") + "</td><td>"
						+ rs.getString("name") + "</td><td>"
						+ ((rs.getInt("sex") == 1 ) ? "男" : "女") + "</td><td>"
						+ rs.getString("birthday") + "</td><td>"
						+ rs.getString("phone") + "</td><td>"
						+ rs.getString("email") + "</td><td>");
				
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
					out.print("</td></tr></main></body></html>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
/*			rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);*/
		}
	}
}
