package cn.itcast.day15.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	//连接池对象
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	
	//公共的取得连接池对象的方法
	public static DataSource getDataSource(){
		return ds;
	}
}
