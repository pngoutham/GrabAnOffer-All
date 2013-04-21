package com.gao.core.notification.dao;

import com.gao.core.framework.hibernate.properties.Notification;

public interface NotificationDao {
	Notification createNotification(Notification notification);

	Notification updateNotfication(Notification notification);

	boolean deleteNotfication(Notification notification);
}
