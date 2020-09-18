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
@Table(name = "position")
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pos_id")
	private int id;
	
	@Column(name = "pos_level")
	private int level;
	
	@Column(name = "pos_name")
	private String name;
	
	@OneToMany(mappedBy = "position", cascade = CascadeType.PERSIST)
	private List<Employee> employee;
	
}
