package Day5;
import java.util.*;

public class Task5 {
    static ArrayList<String> studentNames = new ArrayList<>();
    static HashMap<Integer, List<String>> studentCourses = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Add Student and Courses");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Delete Student");
            System.out.println("4. Delete Course from Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addStudent(); break;
                case 2: searchStudent(); break;
                case 3: deleteStudent(); break;
                case 4: deleteCourse(); break;
                case 5: displayAll(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        if (studentCourses.containsKey(id)) {
            System.out.println("Student ID already exists!");
            return;
        }

        studentNames.add(name);
        List<String> courses = new ArrayList<>();

        System.out.println("Enter course names (type 'done' to stop):");
        while (true) {
            String course = sc.nextLine();
            if (course.equalsIgnoreCase("done")) break;
            courses.add(course);
        }

        studentCourses.put(id, courses);
        System.out.println("Student added successfully!");
    }

    static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (studentCourses.containsKey(id)) {
            System.out.println("Student ID: " + id);
            System.out.println("Courses: " + studentCourses.get(id));
        } else {
            System.out.println("Student not found.");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (studentCourses.containsKey(id)) {
            studentCourses.remove(id);
            System.out.println("Student and their courses deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    static void deleteCourse() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!studentCourses.containsKey(id)) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter course name to remove: ");
        String course = sc.nextLine();

        List<String> courses = studentCourses.get(id);
        if (courses.remove(course)) {
            System.out.println("Course removed.");
        } else {
            System.out.println("Course not found for this student.");
        }
    }

    static void displayAll() {
        if (studentCourses.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        System.out.println("--- All Students and Courses ---");
        for (Map.Entry<Integer, List<String>> entry : studentCourses.entrySet()) {
            System.out.println("Student ID: " + entry.getKey());
            System.out.println("Courses: " + entry.getValue());
            System.out.println("--------------------------");
        }
    }
}
