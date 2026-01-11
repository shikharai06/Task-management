package com.app.dto;

import java.time.LocalDate;

public class CreateTaskRequest {

	// request boddy contains :- title , description , status , due_date;
	public String title;
	public String description;
	public LocalDate due_date;

}
