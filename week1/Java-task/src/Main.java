public class Main {
    public static void main(String[] args) throws Exception {
        EmployeeJDBC db = new EmployeeJDBC();

        // Create
        Employee e1 = new Employee(1, "John Doe", "HR");
        db.create(e1);

        // Read
        for (Employee e : db.read()) {
            System.out.println(e.getId() + " " + e.getName() + " " + e.getDepartment());
        }

        // Update
        e1.setName("Jane Doe");
        db.update(e1);

        // Delete
        db.delete(1);
    }
}
