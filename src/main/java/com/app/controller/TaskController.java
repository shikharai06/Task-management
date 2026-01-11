package com.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CreateTaskRequest;
import com.app.dto.TaskResponse;
import com.app.dto.UpdateTaskRequest;
import com.app.model.entity.Task;
import com.app.service.TaskServiceImpl;

@RestController
@RequestMapping("/tasks")
@CrossOrigin
public class TaskController {

	private final TaskServiceImpl taskServiceImpl;

	public TaskController(TaskServiceImpl taskServiceImpl) {
		this.taskServiceImpl = taskServiceImpl;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TaskResponse create(@RequestBody CreateTaskRequest request) {
		return toResponse(taskServiceImpl.create(request.title, request.description, request.due_date));

	}

	// get task by id
	@GetMapping("/{id}")
	public TaskResponse get(@PathVariable String id) {
	      
		return toResponse(taskServiceImpl.getById(id));
	}

	// update task
	@PutMapping("/{id}")
	public TaskResponse update(@PathVariable String id, @RequestBody UpdateTaskRequest request) {
		return toResponse(
				taskServiceImpl.update(id, request.title, request.description, request.status, request.due_date));
	}

	// delete task by id
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		taskServiceImpl.delete(id);
	}

	// get all task
	@GetMapping
	public List<TaskResponse> list() {
		System.out.println("in function");
		return taskServiceImpl.findAll().stream().map(this::toResponse).toList();

	}

	// helper function

	private TaskResponse toResponse(Task task) {
		return new TaskResponse(task.getId().getValue(), task.getTitle().getTitle(), task.getDescription(),
				task.getStatus(), task.getDueDate().getValue());
	}

}
