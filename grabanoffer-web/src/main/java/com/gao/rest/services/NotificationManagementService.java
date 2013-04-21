package com.gao.rest.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.gao.core.notification.service.NotificationService;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

@Path("/notificationWebService")
public class NotificationManagementService {

	private NotificationService notificationService;

	@Autowired
	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@POST
	@Path("/loginAuthenticate")
	public Response sendNotificationService(
			@QueryParam("username") String username,
			@QueryParam("password") String password) {

		return null;
	}

	@GET
	@Path("/hello")
	public Response getMsg() {
		String output = "Jersey say : bollo";
		return Response.status(200).entity(output).build();
	}
}
