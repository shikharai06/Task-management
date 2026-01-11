package com.app.dto;

import java.time.LocalDate;

import com.app.model.TaskStatus;

public class TaskResponse {
// response for get task request with given task ud 

	public String id;
	public String title;
	public String description;

	public TaskStatus status;
	public LocalDate due_date;

	public TaskResponse(String id, String title, String description, TaskStatus status, LocalDate due_date) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.due_date = due_date;
	}

}
