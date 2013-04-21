package com.gao.core.notification.service;

import com.gao.core.framework.hibernate.properties.Notification;

public interface NotificationService {
	Notification createNotification(Notification notification);

	Notification updateNotfication(Notification notification);

	boolean deleteNotfication(Notification notification);
}
