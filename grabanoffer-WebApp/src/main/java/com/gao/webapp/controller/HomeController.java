package com.gao.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping("/home.htm")
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Welcome to BusinessAdda - Na Business Na istam");
		return "Home";
	}
	
	@RequestMapping("/reg.htm")
	public String registrationService(){
		System.out.println("Registration.................");
		return "Home";
	}
	
	@RequestMapping("/login.htm")
	public String loginService(){
		System.out.println("LOGED IN.................");
		return "Home";
	}
	
}
