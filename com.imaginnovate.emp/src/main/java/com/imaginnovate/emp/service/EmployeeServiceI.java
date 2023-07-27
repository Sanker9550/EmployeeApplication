package com.imaginnovate.emp.service;

import com.imaginnovate.emp.dto.EmpDto;
import com.imaginnovate.emp.dto.EmpTaxDto;

public interface EmployeeServiceI {

	

	public EmpDto createEmployee(EmpDto dto);

	EmpTaxDto getEmployeeAndTaxdeductionAmt(Long id);
	
}
