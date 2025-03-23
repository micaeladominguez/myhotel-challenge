package com.employees.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.employees.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
