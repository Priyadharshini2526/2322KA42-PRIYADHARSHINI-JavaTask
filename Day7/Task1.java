package Day7;
//Task 1: Connect to MySQL DB
import java.sql.*;

public class Task1 {
 public static void main(String[] args) {
     // Replace with your details
     String url = "jdbc:mysql://localhost:3306/studentdb"; 
     String user = "root"; 
     String password = "Dharshini@26"; 

     try {
         Class.forName("com.mysql.cj.jdbc.Driver"); // Load driver
         Connection con = DriverManager.getConnection(url, user, password); // Connect
         System.out.println("✅ Connection Successful!");
         con.close();
     } catch (Exception e) {
         System.out.println("❌ Error: " + e.getMessage());
     }
 }
}


