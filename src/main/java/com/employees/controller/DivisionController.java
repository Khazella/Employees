package com.employees.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employees.dto.DivisionDTO;
import com.employees.repositories.DivisionRepository;
import com.employees.service.DivisionService;

@RestController
@RequestMapping("main")
public class DivisionController {

	@Autowired
	DivisionRepository divisionRepository;
	
	@Autowired
	DivisionService divisionService;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("/divisions")
	public ResponseEntity<List<DivisionDTO>> getAllPositions(
            @RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
			List<DivisionDTO> list = divisionService.getAllDivisions(pageNo, pageSize, sortBy);

			return new ResponseEntity<List<DivisionDTO>>(list, new HttpHeaders(), HttpStatus.OK); 
	}
}
