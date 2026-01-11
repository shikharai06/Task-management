package com.app.model.valueobject;

import java.time.LocalDate;

public class DueDate {

	private final LocalDate value;

	public DueDate(LocalDate value) {
		// date is required field AND must not an past date
		if (value == null || value.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("Due date must be today or in the future");
		}
		this.value = value;
	}

	public LocalDate getValue() {
		return value;
	}

}
