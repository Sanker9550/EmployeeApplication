package com.imaginnovate.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovate.emp.entity.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
