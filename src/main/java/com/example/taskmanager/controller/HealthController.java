package com.example.taskmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/health")
@Tag(name= "Health API", description = "Application Health Checkpoints")
public class HealthController {
	
	@GetMapping
	@Operation(
			summary = "Health check",
			description = "Returns application status")
	public String healthCheck() {
		return "Task manager backend is running" ;
	}

}
