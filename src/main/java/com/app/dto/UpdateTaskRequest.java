package com.app.dto;

import java.time.LocalDate;

import com.app.model.TaskStatus;

public class UpdateTaskRequest {
	// request body title , description , status, due_date;
	public String title;
	public String description;
	public TaskStatus status;
	public LocalDate due_date;

}
