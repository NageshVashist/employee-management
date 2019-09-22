package com.societegenerale.employeemanagement.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		ResponseEntity<Employee> empRes = new ResponseEntity<Employee>(empService.saveEmployee(emp),
				HttpStatus.CREATED);

		return empRes;
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable int id) {

		ResponseEntity<Employee> empRes = new ResponseEntity<Employee>(empService.updateeEmployee(emp, id),
				HttpStatus.CREATED);

		return empRes;
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
		ResponseEntity<Employee> empRes = new ResponseEntity<Employee>(empService.removeEmployee(id),
				HttpStatus.MOVED_PERMANENTLY);

		return empRes;

	}

}
