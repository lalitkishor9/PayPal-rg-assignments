package com.rgassignments.employee.dao;

import com.rgassignments.employee.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    void createTable(); // Helper method to create the table
    void save(Employee employee);
    Optional<Employee> findById(int id);
    List<Employee> findAll();
    void update(Employee employee);
    void delete(int id);
}