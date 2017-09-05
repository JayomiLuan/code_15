package cn.itcast.day15.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用来演示request常用方法
 */
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println( "method: " + req.getMethod() );
		System.out.println( "contextPath: " + req.getContextPath() );
		System.out.println( "queryString: " + req.getQueryString() );
		System.out.println( "remoteAddr: " + req.getRemoteAddr() );
		System.out.println( "uri: " + req.getRequestURI() );
		System.out.println( "url: " + req.getRequestURL() );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
