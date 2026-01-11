package com.example.taskmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")

public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;
	
	@Column(length = 500)
	private String description;
	
	@Column(nullable = false)
	private boolean completed;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String decription) {
		this.description = decription;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean complpeted) {
		this.completed = complpeted;
	}

	public Task(Long id, String title, String decription, boolean completed) {
		super();
		this.id = id;
		this.title = title;
		this.description = decription;
		this.completed = completed;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
