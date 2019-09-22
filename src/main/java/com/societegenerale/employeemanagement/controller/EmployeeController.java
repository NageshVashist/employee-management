package com.societegenerale.employeemanagement.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.societegenerale.employeemanagement.bean.Employee;

/**
 * Employee controller is responsible for handling employee rest calls
 **/
@RestController
public class EmployeeController {

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();

		employees.add(new Employee("Nagesh", "Vashist", "Male", new Date(), "R&D"));

		return employees;
	}
}
