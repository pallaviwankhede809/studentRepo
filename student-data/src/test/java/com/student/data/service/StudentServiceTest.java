package com.student.data.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.student.data.dao.StudentRepository;
import com.student.data.model.Department;
import com.student.data.model.Student;

@SpringBootTest
class StudentServiceTest {

	@Autowired
	private StudentService studentService;
	
	@MockBean
	private StudentRepository springRepository;
	
	public List<Student> student =  new ArrayList<>(
			 Arrays.asList(
					new Student("1","pallavi","wankhede","awb","12-01-1991" ),
					new Student("2","praju","wankhede","awb","26-14-1988" ),
					new Student("3","satish","wankhede","awb","13-07-1991" )
					));
	
	public Department department = new Department("1001","bio");
	

	@Test
	void getAllStudents() 
	{
		when(springRepository.findByDepartmentId("1001")).thenReturn(student);
		
		assertEquals(3, studentService.getAllStudents("1001").size());
	}


	@Test
	void testGetStudentById() {
		
		Student studentObj = new Student("1","pallavi","wankhede","awb","12-01-1991" );
		
		Optional<Student> student = Optional.of(studentObj);
		when(springRepository.findById("1")).thenReturn(student);
		
		assertEquals(studentObj, studentService.getStudentById("1"));
	}

	@Test
	void testAddStudent() {
		Student studentObj = new Student("1","pallavi","wankhede","awb","12-01-1991" );
		
		springRepository.save(studentObj);
		verify(springRepository,times(1)).save(studentObj);
	}

	@Test
	void testRemoveStudent() {
		Student studentObj = new Student("1","pallavi","wankhede","awb","12-01-1991" );
		
		springRepository.delete(studentObj);
		verify(springRepository,times(1)).delete(studentObj);
	}

	@Test
	void testUpdateStudent() {
		Student studentObj = new Student("1","pallavi","wankhede","awb","12-01-1991" );
		
		springRepository.save(studentObj);
		verify(springRepository,times(1)).save(studentObj);
	}

}
