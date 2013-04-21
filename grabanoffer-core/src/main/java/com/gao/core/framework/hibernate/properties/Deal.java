package com.gao.core.framework.hibernate.properties;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "Deal")
public class Deal {
	@Id
	private String id;

	private String title;
	private String description;
	private String offer_price;
	private byte[] imageMap;

	public byte[] getImageMap() {
		return imageMap;
	}

	public void setImageMap(byte[] imageMap) {
		this.imageMap = imageMap;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOffer_price() {
		return offer_price;
	}

	public void setOffer_price(String offer_price) {
		this.offer_price = offer_price;
	}
}
