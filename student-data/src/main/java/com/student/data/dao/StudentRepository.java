package com.student.data.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.student.data.model.Student;

public interface StudentRepository extends CrudRepository<Student , String>
{
	public List<Student> findByDepartmentId(String departmentId);
	
}
