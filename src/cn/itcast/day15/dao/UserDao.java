package cn.itcast.day15.dao;

import cn.itcast.day15.domain.User;

public interface UserDao {
	boolean insert( User user ) throws Exception;
}
