package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	
	
	public HomePageController() {
		System.out.println("in ctor of "+getClass());
	}
	@GetMapping("/")
	public String showHomePage(Model map) {
		System.out.println("in show home page");
		return "/index";//AVN : /WEB-INF/views/index.jsp
	}
}
