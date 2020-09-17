package com.employees.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;

import com.employees.prefix.StringPrefixedSequenceIdGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "Employee")
public class Employee {

	@Column(name = "created_date", columnDefinition = "DATE")
	@CreatedDate
	private Timestamp createdOn;// (string, optional),
	
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
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nik")
    @GenericGenerator(
        name = "nik", 
        strategy = "org.thoughts.on.java.generators.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "EM%"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    private String nik;// (string, optional),
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pos_id", nullable = false)
	private Position position;// (integer, optional),
	
	@Column(name = "type")
	String type;// (string, optional) = ['PROMOTION', 'DEMOTION']
	
}
