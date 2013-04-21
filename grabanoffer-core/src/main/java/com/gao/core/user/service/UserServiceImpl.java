package com.gao.core.user.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gao.core.framework.hibernate.properties.Role;
import com.gao.core.framework.hibernate.properties.User;
import com.gao.core.user.dao.UserDao;

public class UserServiceImpl implements UserService {

	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userDao.registerUser(user);
	}

	@Override
	public User getUserDetails(Long user_id) {
		// TODO Auto-generated method stub
		return userDao.getUserDetails(user_id);
	}


	@Override
	public Role getRole(Long role_id) {
		// TODO Auto-generated method stub
		return userDao.getRole(role_id);
	}
}
