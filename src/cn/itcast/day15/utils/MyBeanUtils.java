package cn.itcast.day15.utils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.itcast.day15.domain.User;

public class MyBeanUtils {
	
	public static User populate( HttpServletRequest req ){
		//一、接收表单提交的用户信息
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String[] hobby = req.getParameterValues("hobby");
		
		//二、进行数据封装（封装成User对象）
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setGender(gender);
		user.setHobby( Arrays.toString( hobby ) );

		return user;
	}
	
	//使用反射机制实现的通用封装的简易版（了解）
	public static<T> T  populate( Class<T> t , Map<String,String[]> map ) throws Exception{
		//用泛型实例化对象
		T obj = t.newInstance();
		
		//把map中的值封装到obj对象中
		//Method = t.getMethod( "methodName" , params )
		//name是提交到服务器的名字，同时把首字母变成大字，前面加set，就是对应方法名
		for( String name : map.keySet() ){
			// password -> setPassword
			String methodName = "set" + ( ""+name.charAt(0) ).toUpperCase() + name.substring(1);
			//得到setXXXX方法的对象
			Method method = t.getMethod( methodName , String.class );
			if( method != null ){
				//调用此set方法，把值注入到属性中
				String temp = Arrays.toString( map.get(name) );
				temp = temp.substring(1, temp.length() -1 );
				method.invoke( obj , temp );
			}
		}
	
		//返回封装好的对象
		return obj;
	}
	
	

}
