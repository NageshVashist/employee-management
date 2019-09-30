package com.societegenerale.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.societegenerale.employeemanagement.bean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public List<Employee> findAllByOrderByFirstNameDesc();
}
