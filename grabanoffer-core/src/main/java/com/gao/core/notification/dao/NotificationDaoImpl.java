package com.gao.core.notification.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gao.core.framework.hibernate.properties.Notification;
import com.gao.core.login.dao.LoginDaoImpl;

@Transactional
public class NotificationDaoImpl implements NotificationDao {
	private Logger _logger = LoggerFactory.getLogger(NotificationDaoImpl.class);
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		// super.setSessionFactory(sessionFactory);
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Notification createNotification(Notification notification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notification updateNotfication(Notification notification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteNotfication(Notification notification) {
		// TODO Auto-generated method stub
		return false;
	}

}
