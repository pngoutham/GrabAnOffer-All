package com.gao.core.framework.repository.properties;

import java.util.List;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.gao.core.framework.hibernate.GenericDaoHibernate;
import com.gao.core.framework.hibernate.exceptions.InstanceNotFoundException;
import com.gao.core.framework.repository.exceptions.RepositoryPropertiesNotFoundException;

/**
 * The Dao implementation Interface to fetch jackrabbit repository properties.
 * @author goutham
 */
public class RepositoryPropertiesDaoHibernateJackRabbitImpl extends GenericDaoHibernate<JackRabbitRepositoryProperties, String> implements RepositoryPropertiesDao {

    private static final Logger _logger = LoggerFactory.getLogger(RepositoryPropertiesDaoHibernateJackRabbitImpl.class);

    @Override
    protected Session getSession() {
        return SessionFactoryUtils.getSession(super.sessionFactory, true);
    }

    public JackRabbitRepositoryProperties getRepositoryDetails(String repositoryId) throws RepositoryPropertiesNotFoundException {
        JackRabbitRepositoryProperties jackRabbitRepositoryProperties = null;
        try {
            jackRabbitRepositoryProperties = this.find(repositoryId);
        } catch (InstanceNotFoundException ex) {
            throw new RepositoryPropertiesNotFoundException("Properties not found");
        }
        return jackRabbitRepositoryProperties;
    }

    public List<JackRabbitRepositoryProperties> getRepositoryList()
            throws RepositoryPropertiesNotFoundException {
        return getSession().createQuery("select * from JackRabbitRepositoryProperties").list();
    }
}
