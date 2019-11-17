package com.student.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.data.model.Department;
import com.student.data.model.Student;
import com.student.data.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired StudentService studentService;
	
	/**
	 * @return
	 */
	@RequestMapping("/departments/{departmentId}/students")
	public List<Student> getAllStudents(@PathVariable String departmentId)
	{
		return studentService.getAllStudents(departmentId) ;
		
	}
	
	@RequestMapping("/departments/{departmentId}/students/{id}")
	public Student getStudentById(@PathVariable String id)
	{
		return studentService.getStudentById(id);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/department/{departmentId}/addStudent")
	public void addStudent(@RequestBody Student student, @PathVariable String departmentId)
	{
		student.setDepartment (new Department(departmentId,""));
		studentService.addStudent(student);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/department/{departmentId}/updateStudent/{id}")
	public void updateStudent(@PathVariable String id, @PathVariable String departmentId, @RequestBody Student student )
	{
		student.setDepartment (new Department(departmentId,""));
		studentService.updateStudent(student);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/department/{departmentId}/removeStudent/{id}")
	public void removeStudent(@PathVariable String id)
	{
		 studentService.removeStudent(id);
	}

}
