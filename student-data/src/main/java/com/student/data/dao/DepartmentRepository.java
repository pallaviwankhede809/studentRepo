package com.student.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.student.data.model.Department;

public interface DepartmentRepository extends CrudRepository<Department , String>
{
	
}
