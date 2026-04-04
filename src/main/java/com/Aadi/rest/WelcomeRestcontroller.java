package com.Aadi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeRestcontroller {

	
	@GetMapping
	public String welcomecontroller() {
		
		return "Welcome to Aaditya World";
	}
	
	
	
}
