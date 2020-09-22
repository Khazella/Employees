package com.employees.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employees.dto.EmployeeDTO;
import com.employees.models.Employee;
import com.employees.repositories.EmployeeRepository;
import com.employees.response.NotFoundException;
import com.employees.service.EmployeeService;

@RestController
@RequestMapping("main")
public class EmployeeController {
	
	@Value("${spring.datasource.username}")
	private String userName;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeService employeeService;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
			List<EmployeeDTO> list = employeeService.getAllEmployees(pageNo, pageSize, sortBy);

			return new ResponseEntity<List<EmployeeDTO>>(list, new HttpHeaders(), HttpStatus.OK); 
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Map<String,Object>> readAuthorById(@PathVariable("id") int id) {
		HashMap<String, Object> results = new HashMap<String, Object>();
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException());
		
		results.put("Data", modelMapper.map(employee, EmployeeDTO.class));
		
		return new ResponseEntity<Map<String,Object>>(results, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Map<String,Object>> creatEmployee(@RequestBody EmployeeDTO employeeDTO) {

		Employee employee = new Employee();
		
		employee = modelMapper.map(employeeDTO, Employee.class);
		employeeRepository.save(employee);	
		
		System.out.println(employee.getId());
		employee.setNik(employeeService.setNikBasedOnId(employee.getId()));
		employeeRepository.save(employee);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(employee.getId()).toUri();
		
		return new ResponseEntity<Map<String,Object>>(new HttpHeaders(), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Object>> deleteEmployee(@PathVariable("id") int id) {
		HashMap<String, Object> results = new HashMap<String, Object>();
		
		employeeRepository.deleteById(id);
		
		return new ResponseEntity<Map<String,Object>>(results, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/employees-sequence")
	public ResponseEntity<Integer> getSequence() {
		
		int result = employeeRepository.sequenceData();
		
		return new ResponseEntity<Integer>(result, new HttpHeaders(), HttpStatus.OK);	
	}
	
}
