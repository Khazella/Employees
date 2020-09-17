package com.employees.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.dto.DivisionDTO;
import com.employees.repositories.DivisionRepository;

@RestController
@RequestMapping("main")
public class DivisionController {

	@Autowired
	DivisionRepository divisionRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("/divisions")
	public ResponseEntity<Map<String,Object>> readAllpositions() {
		Map<String, Object> results = new HashMap<String, Object>();
		List<DivisionDTO> listDivisionDto = new ArrayList<DivisionDTO>();
		
		divisionRepository.findAll().forEach(position -> {
			listDivisionDto.add(modelMapper.map(position, DivisionDTO.class));
		});
		
		results.put("Data", listDivisionDto);
		
		return ResponseEntity.ok(results);
	}
}
