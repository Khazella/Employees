package com.employees.dto;

import java.util.List;

import com.employees.models.Employee;

import lombok.Data;

@Data
public class DivisionDTO {
	
	private int id;
	private String name;
	private List<Employee> employee;
	
}

