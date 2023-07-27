package com.imaginnovate.emp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.imaginnovate.emp.dto.EmpDto;
import com.imaginnovate.emp.dto.EmpTaxDto;
import com.imaginnovate.emp.service.EmpServiceImp;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmpServiceImp empServiceImp;
	
	

	@PostMapping("/employees")
	public ResponseEntity<?> addemploye(@Validated @RequestBody EmpDto empdto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Map<String, String> validationsMap = new HashMap<String, String>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				validationsMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(validationsMap, HttpStatus.BAD_REQUEST);

		} else {

			EmpDto newDto = empServiceImp.createEmployee(empdto);

			return new ResponseEntity<EmpDto>(newDto, HttpStatus.CREATED);
		}
	}
	
	
	
	
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmpTaxDto> getEmployeeTaxDeductionCurrentYear(@PathVariable("id") Long id) {

		return new ResponseEntity<EmpTaxDto>(empServiceImp.getEmployeeAndTaxdeductionAmt(id),
				HttpStatus.OK);

	}

	
	
	
	
	
	

}
