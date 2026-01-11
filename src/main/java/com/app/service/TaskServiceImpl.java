package com.app.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.app.exception.TaskNotFoundException;
import com.app.model.TaskStatus;
import com.app.model.entity.Task;
import com.app.model.valueobject.DueDate;
import com.app.model.valueobject.TaskTitle;
import com.app.repository.TaskRepository;

@Service
public class TaskServiceImpl implements ITaskService {
	
	//@Autowired
	private final TaskRepository repository;
	
	 public TaskServiceImpl(TaskRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}

	@Override
	public Task create(String title, String description, LocalDate dueDate) {
		// TODO Auto-generated method stub
		Task task = new Task(
				new TaskTitle(title), 
				description, 
				new DueDate(dueDate));
		repository.save(task);
		return task;
	}

	@Override
	public Task getById(String id) {
		// TODO Auto-generated method stub
		
		Optional<Task> taskopt= repository.findById(id);
		if(taskopt.isPresent()) {
			return taskopt.get();
		}
		throw new TaskNotFoundException(id);
	}

	@Override
	public Task update(String id, String title, String description, TaskStatus status, LocalDate dueDate) {
		// TODO Auto-generated method stub
		Task task = getById(id);
		task.update(
				title != null ? new TaskTitle(title) : null,
				description, 
				status,
				dueDate != null ? new DueDate(dueDate) : null);
		repository.save(task);
		return task;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		if(repository.findById(id).isEmpty()) {
			throw new RuntimeException("Task not found");
		}
		repository.deleteById(id);
		
	}

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll()
				.stream()
				.sorted(Comparator.comparing(t -> t.getDueDate().getValue()))
				.toList();
	}

	@Override
	public List<Task> findAll(int page, int size, TaskStatus status) {
		// TODO Auto-generated method stub
		// get task based on given info
		List<Task> tasks = (status ==null)
				? repository.findAll()
				: repository.findByStatus(status);
	 // sort the task result based on date 
		tasks.sort(Comparator.comparing(t -> t.getDueDate().getValue()));	
		
		int fromIndex = page*size;
		int toIndex = Math.min(fromIndex + size, tasks.size());
		
		if(fromIndex >=tasks.size()) {
			return List.of();// empty pag
		}
				
		return tasks.subList(fromIndex, toIndex);
			
	}
	
	
	

}
