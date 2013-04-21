package com.gao.core.framework.hibernate.properties;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "Login")
public class Login {

	@Id
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private static final long serialVersionUID = 1L;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String username_hint;
	@Column
	private String password_hint;

	public Login() {

	}

	public Login(String username, String password, String username_hint,
			String password_hint) {
		this.username = username;
		this.password = password;
		this.username_hint = username_hint;
		this.password_hint = password_hint;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername_hint() {
		return username_hint;
	}

	public void setUsername_hint(String username_hint) {
		this.username_hint = username_hint;
	}

	public String getPassword_hint() {
		return password_hint;
	}

	public void setPassword_hint(String password_hint) {
		this.password_hint = password_hint;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
