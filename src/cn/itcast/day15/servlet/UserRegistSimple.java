package cn.itcast.day15.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.day15.domain.User;
import cn.itcast.day15.service.UserService;
import cn.itcast.day15.service.impl.UserServiceImpl;
import cn.itcast.day15.utils.MyBeanUtils;

/**
 * 用户注册的简易版
 * @author Administrator
 *
 */
public class UserRegistSimple extends HttpServlet {
	
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//使用工具取得参数并封装成User对象
		//User user = MyBeanUtils.populate(req);
		
		User user = null;
		try {
			user = MyBeanUtils.populate( User.class , req.getParameterMap() );
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println( "=============" + user );
		
		//三、调用业务逻辑，把数据写入数据库
		boolean flag = false;
		try {
			flag = userService.regist(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//四、显示操作结果给用户
		if( flag ){
			//注册成功
			out.println("<html>");
			out.println("	<head>");
			out.println("		<meta charset=\"UTF-8\" />");
			out.println("		<title>login infomation</title>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("		<font color=\"green\">注册成功！</font>");
			out.println("	</body>");
			out.println("</html>");
		}else{
			//注册失败
			out.println("<html>");
			out.println("	<head>");
			out.println("		<meta charset=\"UTF-8\" />");
			out.println("		<title>login infomation</title>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("		<font color=\"red\">注册失败！</font>");
			out.println("	</body>");
			out.println("</html>");
		}
		
	}

}
