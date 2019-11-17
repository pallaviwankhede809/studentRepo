package com.student.data.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.data.dao.DepartmentRepository;
import com.student.data.model.Department;

@Service
public class DepartmentService 
{
	
	@Autowired
	private DepartmentRepository departmentRepository;
		
	public List<Department> getAllDepartments()
	{
		List<Department> department = new ArrayList<>();
		departmentRepository.findAll().forEach(department :: add);
		return department;
		
	}
	
	public Department getDeparmentbyId(String id)
	{
		
	 return departmentRepository.findById(id).get();
		
	}
	 
	public void addDepartment(Department department)
	{
		departmentRepository.save(department);
	}
	
	public void removeDepartment(String id)
	{
		departmentRepository.deleteById(id);
		
	}

	public void updateDeparment(String id, Department department)  {
		
		departmentRepository.save(department);
	}

}
