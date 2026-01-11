package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.model.TaskStatus;
import com.app.model.entity.Task;

public interface ITaskService {

	Task create(String title, String description, LocalDate dueDate);

	Task getById(String id);

	Task update(String id, String title, String description, TaskStatus status, LocalDate dueDate);

	void delete(String id);

	List<Task> findAll();

	List<Task> findAll(int page, int size, TaskStatus status);
}
