package com.student.data.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.data.dao.StudentRepository;
import com.student.data.model.Student;

@Service
public class StudentService 
{
	
	@Autowired
	private StudentRepository studentRepository;
		
	public List<Student> getAllStudents(String departmentId)
	{
		List<Student> students = new ArrayList<>();
		studentRepository.findByDepartmentId(departmentId).forEach(students :: add);
		return students;
		
	}
	
	public Student getStudentById(String id)
	{
		
	 return studentRepository.findById(id).get();
		
	}
	 
	public void addStudent(Student student)
	{
		studentRepository.save(student);
	}
	
	public void removeStudent(String id)
	{
		studentRepository.deleteById(id);
		
	}

	public void updateStudent(Student student)  {
		
		studentRepository.save(student);
	}

}
