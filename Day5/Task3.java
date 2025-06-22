package Day5;
import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) {
        // Creating a HashMap to store student name and mark
        HashMap<String, Integer> studentMarks = new HashMap<>();

        // Adding student name and marks
        studentMarks.put("Alice", 85);
        studentMarks.put("Bob", 78);
        studentMarks.put("Charlie", 92);
        studentMarks.put("David", 88);

        // Display student marks
        System.out.println("Student Marks:");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Compute average marks
        int sum = 0;
        for (int mark : studentMarks.values()) {
            sum += mark;
        }

        double average = (double) sum / studentMarks.size();
        System.out.println("\nAverage Marks: " + average);
    }
}

