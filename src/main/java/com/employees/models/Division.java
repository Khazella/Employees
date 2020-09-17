package com.employees.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "division")
public class Division {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "div_id")
	private int id;
	
	@Column(name = "div_name")
	private String name;
	
	@OneToMany(mappedBy = "division", cascade = CascadeType.PERSIST)
	private List<Employee> employee;
	
}
