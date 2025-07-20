package com.springbootJPA.Employee_SpringBoot_JPA.repository;

import com.springbootJPA.Employee_SpringBoot_JPA.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Though JpaRepository already makes it a component, it's good practice for clarity
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Spring Data JPA automatically provides CRUD methods (save, findById, findAll, deleteById, etc.)
    // You can add custom query methods like:
    // List<Employee> findByDepartment(String department);
}