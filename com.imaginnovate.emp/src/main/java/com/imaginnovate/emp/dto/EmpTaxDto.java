package com.imaginnovate.emp.dto;

public class EmpTaxDto {
	

	private Long empId;
	private  String firstName;
	private String lastName;
	
	private Double yearlySalary;
	private Double totalSalary;
	private Double taxAmt;
	private Double cessAmt;
	public EmpTaxDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpTaxDto(Long empId, String firstName, String lastName, Double yearlySalary, Double totalSalary,
			Double taxAmt, Double cessAmt) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearlySalary = yearlySalary;
		this.totalSalary = totalSalary;
		this.taxAmt = taxAmt;
		this.cessAmt = cessAmt;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(Double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	public Double getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(Double totalSalary) {
		this.totalSalary = totalSalary;
	}
	public Double getTaxAmt() {
		return taxAmt;
	}
	public void setTaxAmt(Double taxAmt) {
		this.taxAmt = taxAmt;
	}
	public Double getCessAmt() {
		return cessAmt;
	}
	public void setCessAmt(Double cessAmt) {
		this.cessAmt = cessAmt;
	}
	@Override
	public String toString() {
		return "EmpTaxDto [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", yearlySalary="
				+ yearlySalary + ", totalSalary=" + totalSalary + ", taxAmt=" + taxAmt + ", cessAmt=" + cessAmt + "]";
	}
	

}
