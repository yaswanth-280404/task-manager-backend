package com.example.taskmanager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/tasks")
@Tag(name= "TASK API", description = "API's for managing tasks")
public class TaskController {
	
	private final TaskService taskService ;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@PostMapping
	@Operation(summary = "Creating a new task")
	
	public ResponseEntity<Task> createTask (@RequestBody Task task){
		return ResponseEntity.ok(taskService.createTask(task));
	}
	
	@GetMapping
	@Operation(summary = " Get all tasks ")
	public ResponseEntity<List<Task>> getAllTasks(){
		return ResponseEntity.ok(taskService.getAllTask());
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Get task by ID")
	public ResponseEntity<Task> getTaskById(@PathVariable Long id){
		
		return ResponseEntity.ok(taskService.getTaskbyId(id));
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "Update a Task by ID")
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
		return ResponseEntity.ok(taskService.updateTask(id, task));
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete a task by ID")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id){	
		taskService.deleteTask(id);
		return ResponseEntity.noContent().build();
	}
}
