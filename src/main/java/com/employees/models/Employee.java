package com.employees.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "Employee")
//@IdClass(CompositeKey.class)
public class Employee {

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdOn;// (string, optional),
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "div_id", nullable = false)
	private Division division;// (integer, optional),
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	int id;// (integer, optional),
	
	@Column(name = "last_position")
	String lastPosition;// (string, optional),
	
	@Column(name = "name")
	String name;// (string, optional),
	
	@Column(name = "nik")
    private String nik;// (string, optional),
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pos_id", nullable = false)
	private Position position;// (integer, optional),
	
	@Column(name = "type")
	String type;// (string, optional) = ['PROMOTION', 'DEMOTION']

}
