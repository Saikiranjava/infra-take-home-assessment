package com.cathy.example.cathy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cathy.example.cathy.service.NumberService;

@RestController
@RequestMapping("/number")
public class NumberController {
	
	@Autowired
	private NumberService service;
	
	@GetMapping("{number}")
	public ResponseEntity<List<String>> getNumbers(@PathVariable("number") String number){
		
		List<String> numbers = service.possibleNumbers(number);
		
		return new ResponseEntity<List<String>>(numbers, HttpStatus.OK);
	}

}
