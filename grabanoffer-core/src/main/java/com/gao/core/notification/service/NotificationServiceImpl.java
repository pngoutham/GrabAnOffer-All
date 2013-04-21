/**
 * 
 */
package com.gao.core.notification.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gao.core.framework.hibernate.properties.Notification;
import com.gao.core.notification.dao.NotificationDao;

/**
 * @author goutham
 * 
 */
public class NotificationServiceImpl implements NotificationService {

	private NotificationDao notificationDao;

	@Autowired
	public void setNotificationDao(NotificationDao notificationDao) {
		this.notificationDao = notificationDao;
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
