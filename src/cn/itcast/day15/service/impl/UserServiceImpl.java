package cn.itcast.day15.service.impl;

import cn.itcast.day15.dao.UserDao;
import cn.itcast.day15.dao.impl.UserDaoImpl;
import cn.itcast.day15.domain.User;
import cn.itcast.day15.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public boolean regist(User user) throws Exception {
		return userDao.insert(user);
	}

}
