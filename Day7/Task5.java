package Day7;
import java.sql.*;
import java.util.Scanner;

public class Task5 {
    static final String URL = "jdbc:mysql://localhost:3306/InventoryDB";
    static final String USER = "root";
    static final String PASSWORD = "Dharshini@26"; // Change if needed

    public static void main(String[] args) {
        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Scanner sc = new Scanner(System.in)
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            while (true) {
                System.out.println("\n=== Inventory Menu ===");
                System.out.println("1. Add Product");
                System.out.println("2. View All Products");
                System.out.println("3. Search Product by ID");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addProduct(conn, sc);
                        break;
                    case 2:
                        viewProducts(conn);
                        break;
                    case 3:
                        searchProduct(conn, sc);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addProduct(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        String sql = "INSERT INTO products (id, name, price, quantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setDouble(3, price);
            stmt.setInt(4, qty);

            int rows = stmt.executeUpdate();
            System.out.println(rows + " product(s) added.");
        }
    }

    static void viewProducts(Connection conn) throws SQLException {
        String sql = "SELECT * FROM products";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\nID\tName\t\tPrice\tQty");
            System.out.println("-------------------------------------");
            while (rs.next()) {
                System.out.printf("%d\t%-12s%.2f\t%d\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"));
            }
        }
    }

    static void searchProduct(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter Product ID to search: ");
        int id = sc.nextInt();

        String sql = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Product Found:");
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Price: " + rs.getDouble("price"));
                    System.out.println("Quantity: " + rs.getInt("quantity"));
                } else {
                    System.out.println("Product not found.");
                }
            }
        }
    }
}