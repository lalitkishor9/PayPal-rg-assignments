import java.sql.*;
import java.util.*;
import java.io.FileInputStream;

public class EmployeeJDBC {
    Connection conn;

    public EmployeeJDBC() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("db.properties"));
        conn = DriverManager.getConnection(
                props.getProperty("url"),
                props.getProperty("user"),
                props.getProperty("password")
        );
    }

    public void create(Employee e) throws Exception {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO employee VALUES (?, ?, ?)");
        ps.setInt(1, e.getId());
        ps.setString(2, e.getName());
        ps.setString(3, e.getDepartment());
        ps.executeUpdate();
    }

    public List<Employee> read() throws Exception {
        List<Employee> list = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
        while (rs.next()) {
            list.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department")));
        }
        return list;
    }

    public void update(Employee e) throws Exception {
        PreparedStatement ps = conn.prepareStatement("UPDATE employee SET name=?, department=? WHERE id=?");
        ps.setString(1, e.getName());
        ps.setString(2, e.getDepartment());
        ps.setInt(3, e.getId());
        ps.executeUpdate();
    }

    public void delete(int id) throws Exception {
        PreparedStatement ps = conn.prepareStatement("DELETE FROM employee WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
