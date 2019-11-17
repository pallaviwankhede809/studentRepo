package com.student.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.data.model.Department;
import com.student.data.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired DepartmentService departmentService;
	
	/**
	 * @return
	 */
	@RequestMapping("/departments")
	public List<Department> getAllDepartments()
	{
		return departmentService.getAllDepartments() ;
		
	}
	
	@RequestMapping("/departments/{id}")
	public Department getDeparmentbyId(@PathVariable String id)
	{
		return departmentService.getDeparmentbyId(id);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/addDepartment")
	public void addDepartment(@RequestBody Department department)
	{
		departmentService.addDepartment(department);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/updateDepartment/{id}")
	public void updateDeparment(@PathVariable String id, @RequestBody Department department )
	{
		departmentService.updateDeparment(id,department);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/removeDeparment/{id}")
	public void removeDepartment(@PathVariable String id)
	{
		departmentService.removeDepartment(id);
	}

}
