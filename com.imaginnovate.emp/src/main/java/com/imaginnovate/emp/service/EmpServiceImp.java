package com.imaginnovate.emp.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.emp.dto.EmpDto;
import com.imaginnovate.emp.dto.EmpTaxDto;
import com.imaginnovate.emp.entity.Employee;
import com.imaginnovate.emp.exception.EmpException;
import com.imaginnovate.emp.repo.EmployeeRepo;

@Service
public class EmpServiceImp implements EmployeeServiceI {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmployeeRepo emprepo;

	@Override
	public EmpDto createEmployee(EmpDto dto) {

		double yearlySalary = dto.getSalary() * 12.0;
		dto.setSalary(yearlySalary);

		Employee employee = modelMapper.map(dto, Employee.class);
		EmpDto newDto = null;
		Employee savedemployee = null;
		try {

			savedemployee = emprepo.save(employee);

		} catch (Exception e) {
			throw new EmpException("employee allready existed");
		}
		newDto = modelMapper.map(savedemployee, EmpDto.class);
		return newDto;

	}

	@Override
	public EmpTaxDto getEmployeeAndTaxdeductionAmt(Long id) {

		System.out.println(id + ".......");
		EmpTaxDto empp = new EmpTaxDto();

		Double taxAmount = 0.0;
		

		Employee employeebyid = emprepo.findById(id).get();

		if (employeebyid == null) {
			throw new EmpException("EmployeeNotFoundException");
		}

		double yearlySalary = employeebyid.getSalary();

		empp.setEmpId(employeebyid.getEmployeeID());
		empp.setFirstName(employeebyid.getFirstname());
		empp.setLastName(employeebyid.getLastname());

		EmpDto employeeDto = modelMapper.map(employeebyid, EmpDto.class);
		LocalDate employeestartingdate = employeeDto.getDOJ();
		LocalDate employeeendingdate = LocalDate.now();
		long totalemployeemonthsworking = ChronoUnit.MONTHS.between(employeestartingdate, employeeendingdate);
		Double totalsalaryofemployee1 = employeeDto.getSalary() * totalemployeemonthsworking;
		double totalsalaryofemployee = totalsalaryofemployee1 / 12;
		empp.setYearlySalary(yearlySalary);
		empp.setTotalSalary(totalsalaryofemployee);

		

		if (yearlySalary > 1000000) {
			taxAmount = (yearlySalary - 1000000) * 0.2 + 500000 * 0.1 + 250000 * 0.05;
		} else if (yearlySalary > 500000) {
			taxAmount = (yearlySalary - 500000) * 0.1 + 250000 * 0.05;
		} else if (yearlySalary > 250000) {
			taxAmount = (yearlySalary - 250000) * 0.05;
		}

		
		double cessAmount = 0;
		if (yearlySalary > 2500000) {
			cessAmount = (yearlySalary - 2500000) * 0.02;
		}

		empp.setTaxAmt(taxAmount);
		empp.setCessAmt(cessAmount);

		System.out.println(empp);
		return empp;
	}

}
