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

import com.employees.dto.PositionDTO;
import com.employees.models.Position;
import com.employees.repositories.PositionRepository;

@Service
public class PositionService {
	
    @Autowired
    PositionRepository repository;
    
    ModelMapper modelMapper = new ModelMapper();
     
    public List<PositionDTO> getAllPosition(Integer pageNo, Integer pageSize, String sortBy) {
        
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		List<PositionDTO> listPositionDto = new ArrayList<PositionDTO>();
		Page<Position> pagedResult = repository.findAll(paging);
 
		repository.findAll().forEach(position -> {
			listPositionDto.add(modelMapper.map(position, PositionDTO.class));
		});
         
        if(pagedResult.hasContent()) {
            return listPositionDto;
        } else {
            return new ArrayList<PositionDTO>();
        }
    }
}
