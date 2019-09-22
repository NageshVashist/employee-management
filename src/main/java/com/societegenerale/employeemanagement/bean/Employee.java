package com.societegenerale.employeemanagement.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * @author Nagesh This class is responsible to handle User information.
 **/
@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Integer id;

	@Size(min=3, message="First name cannot be less then 3 characters.")
	private String firstName;
	@Size(min=3, message="Last name cannot be less then 3 characters.")
	private String lastName;
	@Size(min=4, max =6, message="Gender cannot be less then 4 and more then 6 characters." )
	private String gender;
	@Past(message = "Date of birth,should be in past.")
	private Date dateOfBirth;
	@NotEmpty(message="department cannot be empty.")
	private String department;

	public Employee() {
	}

	/**
	 * @param firstName: First name of the user
	 * @param lastName: Last name of the user
	 * @param gender: Gender of the user Male/Female
	 * @param dateOfBirth: Date of birth of the user.
	 * @param department: Department of the user.
	 */
	public Employee(String firstName, String lastName, String gender, Date dateOfBirth, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
