package com.example.taskmanager.service;

import java.util.List;

import com.example.taskmanager.dto.TaskRequestDto;
import com.example.taskmanager.dto.TaskResponseDto;

public interface TaskService {
	
	TaskResponseDto createTask(TaskRequestDto dto);
	
	List<TaskResponseDto> getAllTasks();
	
	TaskResponseDto getTaskById(Long id);
	
	TaskResponseDto updateTask(Long id, TaskRequestDto task);
	
	void deleteTask(Long id);

}
