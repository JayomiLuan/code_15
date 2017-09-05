package cn.itcast.day15.dao.impl;

import java.util.Arrays;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.day15.dao.UserDao;
import cn.itcast.day15.domain.User;
import cn.itcast.day15.utils.C3P0Utils;

public class UserDaoImpl implements UserDao {

	/**
	 * 把用户信息插入数据库的tb_user表中
	 */
	@Override
	public boolean insert(User user) throws Exception {
		boolean flag = false;
		
		QueryRunner qr = new QueryRunner( C3P0Utils.getDataSource() );
		int r = qr.update("insert into tb_user(username,password,name,gender,hobby) values(?,?,?,?,?)", 
				user.getUsername(),
				user.getPassword(),
				user.getName(),
				user.getGender(),
				user.getHobby()
			);
		
		if( r == 1 ){
			flag = true;
		}

		return flag;
	}

}
