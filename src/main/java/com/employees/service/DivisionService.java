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

import com.employees.dto.DivisionDTO;
import com.employees.models.Division;
import com.employees.repositories.DivisionRepository;

@Service
public class DivisionService {
	
    @Autowired
    DivisionRepository repository;
    
    ModelMapper modelMapper = new ModelMapper();
     
    public List<DivisionDTO> getAllDivisions(Integer pageNo, Integer pageSize, String sortBy) {
        
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		List<DivisionDTO> listDivisionDto = new ArrayList<DivisionDTO>();
		Page<Division> pagedResult = repository.findAll(paging);
 
		repository.findAll().forEach(position -> {
			listDivisionDto.add(modelMapper.map(position, DivisionDTO.class));
		});
         
        if(pagedResult.hasContent()) {
            return listDivisionDto;
        } else {
            return new ArrayList<DivisionDTO>();
        }
    }
}
