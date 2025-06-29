package Day7;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb"; // Change DB name if needed
        String user = "root";  // Replace with your MySQL username
        String password = "Dharshini@26";  // Replace with your MySQL password

        try {
            // 1. Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // 2. Write SQL insert statement
            String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";

            // 3. Create prepared statement
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 101); // Student ID
            stmt.setString(2, "Priya"); // Student Name
            stmt.setInt(3, 21); // Student Age

            // 4. Execute update
            int rowsInserted = stmt.executeUpdate();

            // 5. Confirm result
            if (rowsInserted > 0) {
                System.out.println("Student data inserted successfully!");
            }

            // 6. Close connection
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}