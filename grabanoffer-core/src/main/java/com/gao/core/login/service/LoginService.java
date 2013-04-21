/**
 * 
 */
package com.gao.core.login.service;

import com.gao.core.framework.hibernate.properties.Login;
import com.gao.core.framework.hibernate.properties.Security;

/**
 * @author goutham
 *
 */
public interface LoginService {
	boolean authenticate(Login login);
	Security forgotPassword(String username);
	boolean validate(Security security);
	Login addLoginData(Login login);
}
