package com.abhishek.batchprocessing.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		
		return "Welcome to Spring Boot: Application Development Session";
	}
	
	@GetMapping("/greet")
	public String greetByName() {
		
		return "Welcome " + LocalDateTime.now();
	}
	
	@GetMapping("/greet/{name}")
	public String greetByName(@PathVariable String name) {
		
		return "Welcome " + name + " to the API development";
		
	}
	
	@GetMapping("/session/{trainer}/{bankid}")
	public Object sessionDetails(@PathVariable String trainer,
								@PathVariable String bankid) {
		
		Map<String, Object> response = new HashMap<String,Object>();
		
		response.put("name", "Spring Boot: Application Development");
		response.put("trainer", trainer);
		response.put("bank_id", bankid);
		response.put("organizer", "Axess Academy");
		response.put("department", "ET");
		
		return response;
		
	}

}
