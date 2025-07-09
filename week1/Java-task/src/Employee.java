//How to Ensure a Class is Encapsulated:
//All fields are marked private
//Access is only allowed through public methods
//Optional: validation logic inside setters

public class Employee {
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return name; }
    public void setDepartment(String name) { this.name = name; }
}

//Fields are private, accessed via public getters/setters.
