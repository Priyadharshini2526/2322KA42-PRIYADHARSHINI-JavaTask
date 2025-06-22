package Day4;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Task3 {
    public static void main(String[] args) {
        String[] lines = {
            "First line",
            "Second line",
            "Third line"
        };

        String filename = "output.txt"; // File will be created in the project root

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine(); // Writes a new line
            }
            System.out.println("Lines written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
