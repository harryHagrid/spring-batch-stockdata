package com.abhishek.batchprocessing.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
public class Employee {
	
	@Id
	private long id;
	
	@Schema(description = "name of the employee", 
			required = true,
			example = "Mark Spencer"
			)
	@Size(min = 3, max=50)
	private String name;
	
	@Schema(description = "name of the department",
			example = "ET"
			)
	@Size(min = 3, max=50)
	private String dept;

	@Schema(description = "name of the location",
			example = "Singapore"
			)
	@Size(min = 3, max=50)
	private String location;
	
	private LocalDateTime timestamp;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	
	
}
