package com.app.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.app.model.TaskStatus;
import com.app.model.entity.Task;

@Repository
public class TaskRepository implements ITaskRepository {

	// using MAp for in memory storage
	private final Map<String, Task> store = new HashMap<>();

	@Override
	public void save(Task task) {
		// TODO Auto-generated method stub
		store.put(task.getId().getValue(), task);

	}

	@Override
	public Optional<Task> findById(String id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		store.remove(id);

	}

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>(store.values());
	}

	@Override
	public List<Task> findByStatus(TaskStatus status) {
		// TODO Auto-generated method stub
		return store.values()
				.stream()
				.filter(task -> task.getStatus() == status)
				.collect(Collectors.toList());
	}

}
