package com.employees.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employees.dto.PositionDTO;
import com.employees.models.Position;
import com.employees.repositories.PositionRepository;
import com.employees.response.NotFoundException;
import com.employees.service.PositionService;


@RestController
@RequestMapping("main")
public class PositionController {
	
	@Autowired
	PositionRepository positionRepository;
	
	@Autowired
	PositionService positionService;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("/positions")
	public ResponseEntity<List<PositionDTO>> getAllPositions(
            @RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
			List<PositionDTO> list = positionService.getAllPosition(pageNo, pageSize, sortBy);

			return new ResponseEntity<List<PositionDTO>>(list, new HttpHeaders(), HttpStatus.OK); 
	}
	
	@GetMapping("/positions/{id}")
	public ResponseEntity<Map<String,Object>> readPositionsById(@PathVariable("id") int id) {
		HashMap<String, Object> results = new HashMap<String, Object>();
		Position position = positionRepository.findById(id)
				.orElseThrow(() -> new NotFoundException());
		
		results.put("Data", modelMapper.map(position, PositionDTO.class));
		
		return ResponseEntity.ok(results);
	}

}
