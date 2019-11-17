package com.student.data.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.student.data.dao.DepartmentRepository;
import com.student.data.model.Department;

@SpringBootTest
class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;
	
	public Department department = new Department("1001","bio");

	@Test
	void testGetAllDepartments() {
		when(departmentRepository.findAll()).thenReturn(Stream.of(department).collect(Collectors.toList()));
		
		assertEquals(1, departmentService.getAllDepartments().size());
	}

	@Test
	void testGetDeparmentbyId() {
		
		Optional<Department> departmentObj = Optional.of(department);
		when(departmentRepository.findById("1001")).thenReturn(departmentObj);
		
		assertEquals(department, departmentService.getDeparmentbyId("1001"));
	}

	@Test
	void testAddDepartment() {
		departmentRepository.save(department);
		verify(departmentRepository,times(1)).save(department);
	}

	@Test
	void testRemoveDepartment() {
		departmentRepository.delete(department);
		verify(departmentRepository,times(1)).delete(department);
	}

	@Test
	void testUpdateDeparment() {
		departmentRepository.save(department);
		verify(departmentRepository,times(1)).save(department);
	}

}
