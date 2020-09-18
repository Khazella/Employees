package com.employees.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.employees.dto.EmployeeDTO;
import com.employees.models.Employee;
import com.employees.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
    @Autowired
    EmployeeRepository repository;
    
    Employee employee;
    
    ModelMapper modelMapper = new ModelMapper();
     
    public List<EmployeeDTO> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy) {
        
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		List<EmployeeDTO> listEmployeeDto = new ArrayList<EmployeeDTO>();
		Page<Employee> pagedResult = repository.findAll(paging);
	
 
		repository.findAll(paging).forEach(employee -> {
			listEmployeeDto.add(modelMapper.map(employee, EmployeeDTO.class));
		});
         
        if(pagedResult.hasContent()) {
            return listEmployeeDto;
        } else {
            return new ArrayList<EmployeeDTO>();
        }
    }
    
    public String setNikBasedOnId(int id) {
    	
    	String StringId = Integer.toString(id);
    	String nik = "";
    	
    	if ( id < 10 ) {
    		nik = "EM0000"+ StringId;
    		System.out.println(StringId);
		}
		else if ( id < 100 ) {
			nik = "EM000"+ StringId;
		}
		else if ( id < 1000 ) {
			nik = "EM00"+ StringId;
		}
		else if ( id < 10000 ) {
			nik = "EM0"+ StringId;
		}
		else if ( id < 100000 ) {
			nik = "EM"+ StringId;
		}
    	
		return nik;
    }
}
