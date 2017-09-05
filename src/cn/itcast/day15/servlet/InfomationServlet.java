package cn.itcast.day15.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InfomationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//从RegistServlet带到本Servlet的要显示的信息
		//在Request中保存的数据适合只用一次
		String msg = (String)req.getAttribute("message");
		
		//显示页面内容
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("		<meta charset=\"UTF-8\" />");
		out.println("		<title>login infomation</title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<font color=\"green\">" + msg + "</font>");
		out.println("	</body>");
		out.println("</html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}
