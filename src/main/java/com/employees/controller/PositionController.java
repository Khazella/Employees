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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employees.dto.PositionDTO;
import com.employees.models.Position;
import com.employees.repositories.PositionRepository;
import com.employees.response.NotFoundException;


@RestController
@RequestMapping("main")
public class PositionController {
	
	@Autowired
	PositionRepository positionRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("/positions")
	public ResponseEntity<Map<String,Object>> readAllPositions() {
		Map<String, Object> results = new HashMap<String, Object>();
		List<PositionDTO> listPositionDto = new ArrayList<PositionDTO>();
		
		positionRepository.findAll().forEach(position -> {
			listPositionDto.add(modelMapper.map(position, PositionDTO.class));
		});
		
		results.put("Data", listPositionDto);
		
		return ResponseEntity.ok(results);
	}
	
	@GetMapping("/positions/")
	public ResponseEntity<Map<String,Object>> readAuthorById(@RequestParam("id") int id) {
		HashMap<String, Object> results = new HashMap<String, Object>();
		Position position = positionRepository.findById(id)
				.orElseThrow(() -> new NotFoundException());
		
		results.put("Message", "Successfully Read Position with ID = " + id);
		results.put("Data", modelMapper.map(position, PositionDTO.class));
		
		return ResponseEntity.ok(results);
	}

}
