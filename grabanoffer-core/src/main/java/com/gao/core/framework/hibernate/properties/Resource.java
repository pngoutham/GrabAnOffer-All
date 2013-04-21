package com.gao.core.framework.hibernate.properties;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Resource implements Serializable {
	@Id
	@GeneratedValue
	private Long id;

	private long creationInMillis;
	private long updateInMillis;
/*
	@ManyToOne(optional = true)
	private User creator;
	@ManyToOne(optional = true)
	private User modifier;*/

	@Version
	private long version;

	public Resource() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getCreationInMillis() {
		return creationInMillis;
	}

	public void setCreationInMillis(long creationInMillis) {
		this.creationInMillis = creationInMillis;
	}

	public long getUpdateInMillis() {
		return updateInMillis;
	}

	public void setUpdateInMillis(long updateInMillis) {
		this.updateInMillis = updateInMillis;
	}

	/*public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public User getModifier() {
		return modifier;
	}

	public void setModifier(User modifier) {
		this.modifier = modifier;
	}
*/
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Resource other = (Resource) obj;
		if (this.creationInMillis != other.creationInMillis) {
			return false;
		}
		if (this.updateInMillis != other.updateInMillis) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 29
				* hash
				+ (int) (this.creationInMillis ^ (this.creationInMillis >>> 32));
		hash = 29 * hash
				+ (int) (this.updateInMillis ^ (this.updateInMillis >>> 32));
		return hash;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}
