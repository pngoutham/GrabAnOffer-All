/**
 * 
 */
package com.gao.core.framework.repository.properties;

/**
 * @author goutham
 * 
 */
public class CustomPropertyDefinationTemplate {

	private String property_id;
	private String property_name;
	private int property_type;
	private boolean isManadatory;
	private boolean isMixin;
	private int required_type;
	private boolean isMultiple;

	public CustomPropertyDefinationTemplate() {
		property_type = -1;
		required_type = -1;
	}

	public int getRequired_type() {
		return required_type;
	}

	public void setRequired_type(int required_type) {
		this.required_type = required_type;
	}

	public boolean isMultiple() {
		return isMultiple;
	}

	public void setMultiple(boolean isMultiple) {
		this.isMultiple = isMultiple;
	}

	public boolean isMixin() {
		return isMixin;
	}

	public void setMixin(boolean isMixin) {
		this.isMixin = isMixin;
	}

	public String getProperty_id() {
		return property_id;
	}

	public void setProperty_id(String property_id) {
		this.property_id = property_id;
	}

	public String getProperty_name() {
		return property_name;
	}

	public void setProperty_name(String property_name) {
		this.property_name = property_name;
	}

	public int getProperty_type() {
		return property_type;
	}

	public void setProperty_type(int property_type) {
		this.property_type = property_type;
	}

	public boolean isManadatory() {
		return isManadatory;
	}

	public void setManadatory(boolean isManadatory) {
		this.isManadatory = isManadatory;
	}
}
