package com.app.model.entity;

import com.app.model.TaskStatus;
import com.app.model.valueobject.DueDate;
import com.app.model.valueobject.TaskId;
import com.app.model.valueobject.TaskTitle;

public class Task {

	// should have , unique ID , a title , a description , staus , due date
	private final TaskId id;
	private TaskTitle title;
	private String description;
	private TaskStatus status;
	private DueDate dueDate;

	public Task( TaskTitle title, String description, DueDate dueDate) {
		super();
		this.id = new TaskId();
		this.title = title;
		this.description = description;
		this.status = TaskStatus.PENDING;
		this.dueDate = dueDate;
	}

	public TaskTitle getTitle() {
		return title;
	}

	public void setTitle(TaskTitle title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public DueDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(DueDate dueDate) {
		this.dueDate = dueDate;
	}

	public TaskId getId() {
		return id;
	}

	// update task

	public void update(TaskTitle title, String description, TaskStatus status, DueDate dueDate) {
		if (title != null)
			this.title = title;
		if (description != null)
			this.description = description;
		if (status != null)
			this.status = status;
		if (dueDate != null)
			this.dueDate = dueDate;
	}

}
