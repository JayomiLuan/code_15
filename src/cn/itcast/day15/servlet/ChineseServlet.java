package cn.itcast.day15.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChineseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//当表单以POST方式提交时，解决中文乱码的方式为设置req的字符集为UTF-8
/*		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		System.out.println( name );
*/
		//当表单以GET方式提交时，req.setCharacterEncoding("UTF-8");不能解决中文乱码问题
		String name = req.getParameter("name");
		//使用String的构造器对ISO-8859-1编码的字符串用UTF-8进行重新编码，解决乱码问题
		//注意，此方式只适用于GET方式，且只能用一次
		name = new String( name.getBytes("ISO-8859-1") , "UTF-8" );
		System.out.println( name );

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
