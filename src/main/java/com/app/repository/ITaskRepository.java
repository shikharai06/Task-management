package com.app.repository;

import java.util.List;
import java.util.Optional;

import com.app.model.TaskStatus;
import com.app.model.entity.Task;

public interface ITaskRepository {

	void save(Task task);

	Optional<Task> findById(String id);

	void deleteById(String id);

	List<Task> findAll();

	// filter by status
	List<Task> findByStatus(TaskStatus status);

}
