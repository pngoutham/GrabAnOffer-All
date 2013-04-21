package com.gao.core.framework.hibernate.properties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "LocationDetails")
public class LocationDetails {

	
	@Id
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	private double altitude;
	private double latitude;
	private double logintude;
	private String android_machine_id;
	private String time_of_day;
	
	public String getTime_of_day() {
		return time_of_day;
	}

	public void setTime_of_day(String time_of_day) {
		this.time_of_day = time_of_day;
	}

	public String getAndroid_machine_id() {
		return android_machine_id;
	}

	public void setAndroid_machine_id(String android_machine_id) {
		this.android_machine_id = android_machine_id;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLogintude() {
		return logintude;
	}

	public void setLogintude(double logintude) {
		this.logintude = logintude;
	}

}
