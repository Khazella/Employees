package com.employees.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employees.dto.EmployeeDTO;
import com.employees.models.Employee;
import com.employees.repositories.EmployeeRepository;
import com.employees.response.NotFoundException;

@RestController
@RequestMapping("main")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("/employees")
	public ResponseEntity<Map<String,Object>> readAllEmployees() {
		Map<String, Object> results = new HashMap<String, Object>();
		List<EmployeeDTO> listEmployeeDto = new ArrayList<EmployeeDTO>();
		
		employeeRepository.findAll().forEach(employee -> {
			listEmployeeDto.add(modelMapper.map(employee, EmployeeDTO.class));
		});
		
		results.put("Data", listEmployeeDto);
		
		return ResponseEntity.ok(results);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Map<String,Object>> readAuthorById(@RequestParam("id") int id) {
		HashMap<String, Object> results = new HashMap<String, Object>();
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException());
		
		results.put("Message", "Successfully Read Position with ID = " + id);
		results.put("Data", modelMapper.map(employee, EmployeeDTO.class));
		
		return ResponseEntity.ok(results);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Map<String,Object>> creatEmployee(@RequestBody EmployeeDTO employeeDTO) {
		HashMap<String, Object> results = new HashMap<String, Object>();
		Employee employee = new Employee();
		
		employee = modelMapper.map(employee, Employee.class);
		employeeRepository.save(employee);
		
		results.put("Data", employeeDTO);
		
		return ResponseEntity.ok(results);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Object>> deleteEmployee(@RequestParam("id") int id) {
		HashMap<String, Object> results = new HashMap<String, Object>();
		
		employeeRepository.deleteById(id);
		
		results.put("Message", "Successfully delete author with ID = " + id);
		return ResponseEntity.ok(results);
	}
}
