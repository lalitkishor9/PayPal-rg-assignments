package com.rgassignments.employee.service;

import com.rgassignments.employee.dao.EmployeeDAO;
import com.rgassignments.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring Service component
public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired // Injects EmployeeDAO via constructor
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void addEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeDAO.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.update(employee);
    }

    public void deleteEmployee(int id) {
        employeeDAO.delete(id);
    }
}