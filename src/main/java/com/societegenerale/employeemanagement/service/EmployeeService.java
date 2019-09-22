package com.societegenerale.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.societegenerale.employeemanagement.bean.Employee;
import com.societegenerale.employeemanagement.repository.EmployeeRepository;
import com.societegenerale.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;

	public List<Employee> getEmployees() {
		return repo.findAll();

	}

	public Employee getEmployee(int id) {
		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new EmployeeNotFoundException("Employee with id-" + id + " not found.");
		}

	}

	public Employee saveEmployee(Employee emp) {
		return repo.save(emp);

	}

	public Employee updateeEmployee(Employee emp, int id) {
		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
			Employee emp1 = optional.get();
			emp1 = emp;
			return repo.save(emp1);
		} else {
			throw new EmployeeNotFoundException("Employee with id-" + id + " not found.");
		}

	}

	public void removeEmployee(int id) {
		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.delete(optional.get());
		} else {
			throw new EmployeeNotFoundException("Employee with id-" + id + " not found.");
		}
	}

}
