package Day7;
import java.sql.*;

public class Task3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentDB"; // Make sure this DB exists
        String user = "root"; // use your MySQL username
        String password = "Dharshini@26"; // your MySQL password (set it if you have one)

        try {
            // Load the JDBC driver (optional in modern versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection conn = DriverManager.getConnection(url, user, password);

            // SQL query to fetch data
            String sql = "SELECT * FROM students";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Execute and get result
            ResultSet rs = stmt.executeQuery();

            // Print data to console
            System.out.println("ID\tName\t\tAge");
            System.out.println("--------------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.printf("%d\t%-15s%d\n", id, name, age);
            }

            // Close everything
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}