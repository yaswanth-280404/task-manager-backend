package com.example.taskmanager.service;

import java.util.List;

import com.example.taskmanager.model.Task;

public interface TaskService {
	
	Task createTask(Task task);
	
	List<Task> getAllTask();
	
	Task getTaskbyId(Long id);
	
	Task updateTask(Long id, Task task);
	
	void deleteTask(Long id);

}
