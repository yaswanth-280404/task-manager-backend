package com.example.taskmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	private final TaskRepository taskRepository;
	
	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public Task createTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.save(task);
	}

	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	@Override
	public Task getTaskbyId(Long id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id)
				.orElse(null);
	}

	@Override
	public Task updateTask(Long id, Task task) {
		// TODO Auto-generated method stub
		Task existingTask = getTaskbyId(id);
		if (existingTask == null) {
			return null;
		}
		
		existingTask.setTitle(task.getTitle());
		existingTask.setId(task.getId());
		existingTask.setCompleted(task.isCompleted());
		
		return taskRepository.save(existingTask);
		
	}

	@Override
	public void deleteTask(Long id) {
		// TODO Auto-generated method stub
		taskRepository.deleteById(id);
		
	}

}
