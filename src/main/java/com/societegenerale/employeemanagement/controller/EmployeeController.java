package com.societegenerale.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.societegenerale.employeemanagement.bean.Employee;
import com.societegenerale.employeemanagement.service.EmployeeService;

/**
 * Employee controller is responsible for handling employee rest calls
 **/
@CrossOrigin()
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	@GetMapping("/employees")
	public List<Employee> getEmployees() {

		return empService.getEmployees();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id) {

		return empService.getEmployee(id);
	}

	@PostMapping("/employees")
	
	public Employee saveEmployee(@RequestBody Employee emp) {
		return empService.saveEmployee(emp);
	}

	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable int id) {

		return empService.updateeEmployee(emp, id);

	}

	@DeleteMapping("/employees/{id}")
	public Employee deleteEmployee(@PathVariable int id) {
		return empService.removeEmployee(id);

	}

}
