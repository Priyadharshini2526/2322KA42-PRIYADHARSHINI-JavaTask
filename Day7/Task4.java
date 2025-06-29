package Day7;
import java.sql.*;
import java.util.Scanner;

public class Task4 {
    private static final String URL = "jdbc:mysql://localhost:3306/studentDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Dharshini@26"; // Add your MySQL password if any

    public static void main(String[] args) {
        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Scanner sc = new Scanner(System.in)
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            while (true) {
                System.out.println("\n--- Student DB Manager ---");
                System.out.println("1. Insert Student");
                System.out.println("2. Display Students");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        insertStudent(conn, sc);
                        break;
                    case 2:
                        displayStudents(conn);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " student(s) inserted successfully.");
        }
    }

    private static void displayStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\nID\tName\t\tAge");
            System.out.println("----------------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.printf("%d\t%-15s%d\n", id, name, age);
            }
        }
    }
}