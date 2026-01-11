package com.app.model.valueobject;

public class TaskTitle {

	private final String title;

	public TaskTitle(String title) {
		// title must be required

		if (title == null || title.trim().isEmpty()) {
			throw new IllegalArgumentException("Title is required");
		}

		this.title = title;

	}
	
	public String getTitle() {
		return title;
	}

}
