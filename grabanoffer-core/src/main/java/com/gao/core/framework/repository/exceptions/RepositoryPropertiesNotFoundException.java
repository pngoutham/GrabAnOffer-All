/**
 * 
 */
package com.gao.core.framework.repository.exceptions;

import javax.jcr.RepositoryException;

/**
 * @author goutham
 * 
 */
public class RepositoryPropertiesNotFoundException extends RepositoryException {
	public RepositoryPropertiesNotFoundException(String exception) {
		super(exception);
	}
}
