package com.employees.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> sendViaResponseEntity() {
		
	    return new ResponseEntity<Object>(new HttpHeaders(), HttpStatus.OK);
	    
	}

}
