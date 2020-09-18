package com.employees.dto;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class EmployeeDTO {

	private int id;
	private String nik;
    private String name;
    private String type;
    private PositionDTO position;
    private DivisionDTO division;
    private String lastPosition;
    private Date createdOn;
    
    
	public EmployeeDTO(int id, String nik, String name, String type, PositionDTO position, DivisionDTO division,
			String lastPosition, Timestamp createdOn) {
		super();
		this.id = id;
		this.nik = nik;
		this.name = name;
		this.type = type;
		this.position = position;
		this.division = division;
		this.lastPosition = lastPosition;
		this.createdOn = createdOn;
	}


	public EmployeeDTO() {
		super();
	}
    
    
}
