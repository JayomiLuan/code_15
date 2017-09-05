package cn.itcast.day15.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import cn.itcast.day15.domain.User2;
import cn.itcast.day15.service.UserService;
import cn.itcast.day15.service.impl.UserServiceImpl;

public class RegistServlet extends HttpServlet {
	//持有业务逻辑对象
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理POST方式提交表单的中文乱码问题
		req.setCharacterEncoding("UTF-8");
		User2 user = new User2();
		try {
			//在封装数据之前，注册一个日期转换器，让BeanUtils支持日期格式从字符串到日期对象的转换
			DateConverter dateConverter = new DateConverter();
			dateConverter.setPattern("yyyy-MM-dd");

			//使用ConverUtils工具注册转换器
			ConvertUtils.register(dateConverter, Date.class);
			
			//使用BeanUtils工具进行封装
			BeanUtils.populate( user , req.getParameterMap() );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println( user );
		
		boolean flag = false;
		try {
//			flag = userService.regist(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//根据执行结果，显示信息页面
		//转跳到InfomationServlet，并显示相应的信息
		if( flag ){
			//成功
			//设置要显示的信息。使用Request域保存信息
			req.setAttribute( "message" , "注册成功！");
		}else{
			//失败
			//设置要显示的信息
			req.setAttribute( "message" , "注册失败！");			
		}
		
		//转跳到显示信息的Servlet，因为使用了Request保存信息，所以只能使用内部转发来进行页面的跳转
		req.getRequestDispatcher("/infoServlet").forward(req, resp);
		
		//引时如果使用重定向，会产生新的请求，之前在请求中保存的message也就不存在了
		//转跳到infoServlet时，得到的是全新的请求对象，所以其中也就没有message数据了
		//resp.sendRedirect("/day15/infoServlet");
		
	}

}
