package com.gao.core.framework.hibernate.properties;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang.StringUtils;

@Entity
public class ImageDocument {

	private static final String DEFAULT_MIME_TYPE = "application/octet-stream";
	@Id
	@GeneratedValue
	private Long id;
	private String nodeId;
	private String nodePath;
	private String fileName;
	private String description;
	private long dataSize;
	private long creationDate;
	private long modificationDate;
	private String mimeType;
	private String[] roles;
	private long creatorId;
	private boolean finalDelivery;
	private boolean visibility;
	private String albumId;

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public ImageDocument() {
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String filename) {
		this.fileName = filename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getDataSize() {
		return dataSize;
	}

	public void setDataSize(long dataSize) {
		this.dataSize = dataSize;
	}

	public long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
	}

	public long getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(long modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public String getMimeType() {
		if (StringUtils.isEmpty(mimeType)) {
			return DEFAULT_MIME_TYPE;
		}
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		if (!(obj instanceof ImageDocument)) {
			return false;
		}

		ImageDocument other = (ImageDocument) obj;
		if ((this.getFileName() == null) ? (other.getFileName() != null)
				: !this.getFileName().equals(other.getFileName())) {
			return false;
		}

		if ((this.getDescription() == null) ? (other.getDescription() != null)
				: !this.getDescription().equals(other.getDescription())) {
			return false;
		}

		if (dataSize != other.dataSize) {
			return false;
		}

		// if (modificationDate != other.modificationDate) {
		// return false;
		// }
		//
		// if (creationDate != other.creationDate) {
		// return false;
		// }

		if ((this.getMimeType() == null) ? (other.getMimeType() != null)
				: !this.getMimeType().equals(other.getMimeType())) {
			return false;
		}

		if (((roles == null) && (other.roles != null))
				|| ((roles != null) && (other.roles == null))) {
			return false;
		}

		if ((roles != null) && (other.roles != null)) {
			if (roles.length != other.roles.length) {
				return false;
			}
			for (int i = 0; i < roles.length; i++) {
				boolean found = false;
				String roleA = roles[i];
				for (int j = 0; j < other.roles.length; j++) {
					String roleB = other.roles[j];
					if (roleA.equals(roleB)) {
						found = true;
					}
				}
				if (!found) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 29 * hash + (int) (this.dataSize ^ (this.dataSize >>> 32));
		hash = 29 * hash + Arrays.deepHashCode(this.roles);
		return hash;
	}

	/**
	 * @return the nodePath
	 */
	public String getNodePath() {
		return nodePath;
	}

	/**
	 * @param nodePath
	 *            the nodePath to set
	 */
	public void setNodePath(String nodePath) {
		this.nodePath = nodePath;
	}

	public long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(long creatorId) {
		this.creatorId = creatorId;
	}

	public boolean isFinalDelivery() {
		return finalDelivery;
	}

	public void setFinalDelivery(boolean finalDelivery) {
		this.finalDelivery = finalDelivery;
	}
}
