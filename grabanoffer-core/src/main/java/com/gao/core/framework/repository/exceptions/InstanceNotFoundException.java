/**
 * 
 */
package com.gao.core.framework.repository.exceptions;

/**
 * @author goutham
 * 
 */
public class InstanceNotFoundException extends InstanceException {
	public InstanceNotFoundException(Object key, String className) {
		super("Instance not found", key, className);
	}

}
