import java.util.*;

public class EmployeeCRUD {
    List<Employee> employees = new ArrayList<>();

    public void create(Employee e) { employees.add(e); }
    public List<Employee> read() { return employees; }
    public void update(int id, Employee updated) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                e.setName(updated.getName());
                e.setDepartment(updated.getDepartment());
                break;
            }
        }
    }
    public void delete(int id) {
        employees.removeIf(e -> e.getId() == id);
    }
}
