package com.rgassignments.employee.dao;

import com.rgassignments.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository // Marks this class as a Spring Repository component
public class EmployeeDAOImpl implements EmployeeDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired // Injects JdbcTemplate via constructor
    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS employees (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(255) NOT NULL," +
                "department VARCHAR(255)" +
                ")";
        jdbcTemplate.execute(sql);
        System.out.println("Employee table created or already exists.");
    }

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employees (name, department) VALUES (?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment());
        System.out.println("Employee saved: " + employee.getName());
    }

    @Override
    public Optional<Employee> findById(int id) {
        String sql = "SELECT id, name, department FROM employees WHERE id = ?";
        try {
            Employee employee = jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
            return Optional.ofNullable(employee);
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            return Optional.empty(); // Employee not found
        }
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT id, name, department FROM employees";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getId());
        if (rowsAffected > 0) {
            System.out.println("Employee updated: " + employee.getName() + " (ID: " + employee.getId() + ")");
        } else {
            System.out.println("Employee with ID " + employee.getId() + " not found for update.");
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        if (rowsAffected > 0) {
            System.out.println("Employee deleted with ID: " + id);
        } else {
            System.out.println("Employee with ID " + id + " not found for deletion.");
        }
    }

    // Inner class for mapping ResultSet rows to Employee objects
    private static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setDepartment(rs.getString("department"));
            return employee;
        }
    }
}