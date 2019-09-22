package com.societegenerale.employeemanagement.bean;

import java.util.Date;

/**
 * @author Nagesh This class is responsible to handle User information.
 **/
public class Employee {

	private String firstName;
	private String lastName;
	private String gender;
	private Date dateOfBirth;
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

}
