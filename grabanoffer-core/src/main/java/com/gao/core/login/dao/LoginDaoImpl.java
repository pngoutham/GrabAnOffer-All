/**
 * 
 */
package com.gao.core.login.dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gao.core.framework.hibernate.GenericDaoHibernate;
import com.gao.core.framework.hibernate.properties.Login;
import com.gao.core.framework.hibernate.properties.Security;

/**
 * @author goutham
 * 
 */
@Transactional
public class LoginDaoImpl implements LoginDao {

	private Logger _logger = LoggerFactory.getLogger(LoginDaoImpl.class);
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		// super.setSessionFactory(sessionFactory);
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean authenticate(Login login) {
		boolean result = false;
		Session session = null;

		try {

			session = sessionFactory.openSession();
			session.beginTransaction();
			if (session.get(Login.class, 1l) != null) {
				result = true;
			}
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	@Override
	public Security forgotPassword(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validate(Security security) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Login addLoginData(Login login) {

		Login result = null;
		Session session = null;

		try {

			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(login);
			session.getTransaction().commit();
			result = login;

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		/*
		 * try { session =
		 * HibernateSessionFactory.getSessionFactory().openSession();
		 * session.beginTransaction(); session.getTransaction().commit(); }
		 * catch (HibernateException hex) { try {
		 * session.getTransaction().rollback(); } catch (Exception e) { // just
		 * log warn } String msg = "Error occured in getCustomerId Cause: " +
		 * hex; _logger.error(msg); throw new HibernateException(msg); } finally
		 * { if (session != null) { session.close(); } }
		 */
		return result;

	}
}
