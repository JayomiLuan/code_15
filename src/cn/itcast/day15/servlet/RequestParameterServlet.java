package cn.itcast.day15.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class RequestParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //第一种取得方式：getParameter
        //只能得到第一个值，如果有多个值，则只取得第一个，其它的无法取得
/*		String v = req.getParameter("name");
        System.out.println( "name: " + v );*/
        //第二种取得方式：getParameterValues
/*		String[] hobbies = req.getParameterValues("hobby");
		System.out.println( Arrays.toString( hobbies ) );*/
        //第三种取得方式：getParameterNames
/*		Enumeration<String> names = req.getParameterNames();
		while( names.hasMoreElements() ){
			String name = names.nextElement();
			System.out.println( name + " -> " + Arrays.toString( req.getParameterValues(name) ) );
		}*/
        //第四种取得方式：getParameterMap
        Map<String, String[]> map = req.getParameterMap();
        for (String name : map.keySet()) {
            String[] values = map.get(name);
            System.out.println(name + " -> " + Arrays.toString(values));
        }

        //前两种方式适合程序员直接使用（因为程序知道提交的值的名字）
        //后两种方式适合框架使用（可以得到所有，可以用于编写通用代码）

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
