package com.employees.dto;

import java.sql.Timestamp;

import com.employees.models.Division;
import com.employees.models.Position;

import lombok.Data;

@Data
public class EmployeeDTO {

	private int id;
	private String nik;
    private String name;
    private String type;
    private Position position;
    private Division division;
    String lastPosition;
    private Timestamp createdOn;
}
