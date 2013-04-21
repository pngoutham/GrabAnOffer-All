package com.gao.core.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gao.core.framework.hibernate.properties.Login;
import com.gao.core.framework.hibernate.properties.Security;
import com.gao.core.login.dao.LoginDao;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public boolean authenticate(Login login) {
		// TODO Auto-generated method stub
		return loginDao.authenticate(login);
	}

	@Override
	public Security forgotPassword(String username) {
		// TODO Auto-generated method stub
		return loginDao.forgotPassword(username);
	}

	@Override
	public boolean validate(Security security) {
		// TODO Auto-generated method stub
		return loginDao.validate(security);
	}

	@Override
	public Login addLoginData(Login login) {
		// TODO Auto-generated method stub
		return loginDao.addLoginData(login);
	}

}
