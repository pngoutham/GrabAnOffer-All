package com.gao.core.user.dao;

import com.gao.core.framework.hibernate.properties.Role;
import com.gao.core.framework.hibernate.properties.User;

public interface UserDao {
	User registerUser(User user);

	User getUserDetails(Long user_id);

	Role getRole(Long role_id);
}
