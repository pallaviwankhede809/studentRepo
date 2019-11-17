package com.student.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Student
{

	@Id
	private String Id;
	
	private String firstName;
	private String lastName;
	private String address;
	private String dob;
	
	@ManyToOne
	private Department department;
	
	
	/**
	 * 
	 */
	public Student() 
	{
	
	}

	
	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param dob
	 */
	public Student(String id, String firstName, String lastName, String address, String dob, String departmentId) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.dob = dob;
		this.department = new Department(departmentId,"");
	}

	public Student(String id, String firstName, String lastName, String address, String dob) {
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.dob = dob;
	}



	/**
	 * @return the id
	 */
	public String getId() {
		return Id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		Id = id;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}


	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}


	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}


	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

		
		
}
