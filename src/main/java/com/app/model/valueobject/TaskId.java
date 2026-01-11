package com.app.model.valueobject;

import java.util.UUID;

public class TaskId {
	private final String value;
	
	public TaskId() {
		this.value = UUID.randomUUID().toString(); // to make sure we are generating a unique Identifier 
		
	}
	
	// need a get method to get private member of the class
	public String getValue() {
		return value;
	}

}
