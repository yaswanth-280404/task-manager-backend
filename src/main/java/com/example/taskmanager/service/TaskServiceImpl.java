package com.example.taskmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.taskmanager.dto.TaskRequestDto;
import com.example.taskmanager.dto.TaskResponseDto;
import com.example.taskmanager.exception.ResourceNotFoundException;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	private final TaskRepository taskRepository;
	
	private TaskResponseDto mapToResponse (Task task) {
		TaskResponseDto dto = new TaskResponseDto();
		dto.setId(task.getId());
		dto.setTitle(task.getTitle());
		dto.setDescription(task.getDescription());
		dto.setCompleted(task.isCompleted());
		return dto;		
	}
	
	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public TaskResponseDto createTask(TaskRequestDto dto) {
		// TODO Auto-generated method stub
		Task task = new Task();
		task.setTitle(dto.getTitle());
		task.setDescription(dto.getDescription());
		task.setCompleted(dto.isCompleted());
		return mapToResponse(taskRepository.save(task));
	}

	@Override
	public List<TaskResponseDto> getAllTasks() {
		// TODO Auto-generated method stub
		return taskRepository.findAll().
				stream().
				map(this::mapToResponse).
				toList();
	}

	@Override
	public TaskResponseDto getTaskById(Long id) {
		// TODO Auto-generated method stub
		Task task = taskRepository.findById(id).
				orElseThrow(() -> 
				new ResourceNotFoundException("Task not found with the id: " + id));
		return mapToResponse(task);
	}

	@Override
	public TaskResponseDto updateTask(Long id, TaskRequestDto dto) {
		Task task = taskRepository.findById(id).
				orElseThrow(() -> 
				new ResourceNotFoundException("Task not found with this id: " + id));
		task.setTitle(dto.getTitle());
		task.setDescription(dto.getDescription());
		task.setCompleted(dto.isCompleted());
		
		return mapToResponse(taskRepository.save(task));
		
	}

	@Override
	public void deleteTask(Long id) {
	    Task task = taskRepository.findById(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException("Task not found with id: " + id));

	    taskRepository.delete(task);
	}


}
