package com.employees.dto;

import java.util.List;

import com.employees.models.Employee;

import lombok.Data;

@Data
public class PositionDTO {
	
	private int id;
	private int level;
	private String name;
	private List<Employee> employee;

}
