package com.rgassignments.employee.model;

public class Employee {
    private int id;
    private String name;
    private String department;

    // Default constructor (important for JdbcTemplate's RowMapper)
    public Employee() {
    }

    // Constructor for creating new employees (without ID, as it's auto-generated)
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Constructor for retrieving existing employees
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}