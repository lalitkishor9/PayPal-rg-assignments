

package com.rgassignments.employee;

import com.rgassignments.employee.config.AppConfig;
import com.rgassignments.employee.dao.EmployeeDAO;
import com.rgassignments.employee.model.Employee;
import com.rgassignments.employee.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Create Spring application context from AppConfig
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the EmployeeService bean from the context
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        EmployeeDAO employeeDAO = context.getBean(EmployeeDAO.class);

        // 1. Create the table (important for in-memory H2)
        employeeDAO.createTable();
        System.out.println("\n--- Initializing DB ---");

        // 2. Add Employees
        System.out.println("\n--- Adding Employees ---");
        employeeService.addEmployee(new Employee("Alice Smith", "HR"));
        employeeService.addEmployee(new Employee("Bob Johnson", "IT"));
        employeeService.addEmployee(new Employee("Charlie Brown", "Finance"));

        // 3. List All Employees
        System.out.println("\n--- All Employees ---");
        List<Employee> allEmployees = employeeService.getAllEmployees();
        allEmployees.forEach(System.out::println);

        // 4. Find Employee by ID
        System.out.println("\n--- Finding Employee with ID 2 ---");
        Optional<Employee> foundEmployee = employeeService.getEmployeeById(2);
        foundEmployee.ifPresentOrElse(
                emp -> System.out.println("Found: " + emp),
                () -> System.out.println("Employee with ID 2 not found.")
        );

        System.out.println("\n--- Finding Non-existent Employee with ID 99 ---");
        Optional<Employee> nonExistentEmployee = employeeService.getEmployeeById(99);
        nonExistentEmployee.ifPresentOrElse(
                emp -> System.out.println("Found: " + emp),
                () -> System.out.println("Employee with ID 99 not found.")
        );


        // 5. Update an Employee
        System.out.println("\n--- Updating Employee with ID 1 ---");
        Employee employeeToUpdate = new Employee(1, "Alice Williams", "Marketing");
        employeeService.updateEmployee(employeeToUpdate);
        employeeService.getEmployeeById(1).ifPresent(System.out::println);


        // 6. Delete an Employee
        System.out.println("\n--- Deleting Employee with ID 3 ---");
        employeeService.deleteEmployee(3);

        // 7. List All Employees After Deletion
        System.out.println("\n--- All Employees After Deletion ---");
        allEmployees = employeeService.getAllEmployees();
        allEmployees.forEach(System.out::println);

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}
