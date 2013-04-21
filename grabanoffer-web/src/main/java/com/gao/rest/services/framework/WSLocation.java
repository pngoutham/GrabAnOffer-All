package com.gao.rest.services.framework;

public interface WSLocation {
	void postGPSLocation(String altitue, String longitude, String latitude);
	void postLocation(String location_name);
	void getLocation();
	void getGPSLocation();
}
