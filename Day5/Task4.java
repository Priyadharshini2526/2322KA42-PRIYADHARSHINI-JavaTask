package Day5;
import java.util.*;
import java.io.*;

class Task4 {
    private static ArrayList<String> studentNames = new ArrayList<>();
    private static HashMap<Integer, List<String>> studentCourses = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Add Course to Student");
            System.out.println("5. Delete Course from Student");
            System.out.println("6. View All Students & Courses");
            System.out.println("7. Save Courses to File");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    addCourse();
                    break;
                case 5:
                    deleteCourse();
                    break;
                case 6:
                    viewAllStudents();
                    break;
                case 7:
                    saveToFile();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // 1. Add a new student
    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        studentNames.add(name);
        studentCourses.put(id, new ArrayList<>());
        System.out.println("Student added successfully!");
    }

    // 2. Search for a student by ID
    private static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (studentCourses.containsKey(id)) {
            System.out.println("Student found!");
            System.out.println("Courses: " + studentCourses.get(id));
        } else {
            System.out.println("Student not found!");
        }
    }

    // 3. Delete a student by ID
    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (studentCourses.containsKey(id)) {
            studentCourses.remove(id);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // 4. Add a course to a student
    private static void addCourse() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (studentCourses.containsKey(id)) {
            System.out.print("Enter course name: ");
            String course = scanner.nextLine();
            studentCourses.get(id).add(course);
            System.out.println("Course added successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // 5. Delete a course from a student
    private static void deleteCourse() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (studentCourses.containsKey(id)) {
            System.out.print("Enter course to delete: ");
            String course = scanner.nextLine();
            if (studentCourses.get(id).remove(course)) {
                System.out.println("Course deleted successfully!");
            } else {
                System.out.println("Course not found!");
            }
        } else {
            System.out.println("Student not found!");
        }
    }

    // 6. View all students and their courses
    private static void viewAllStudents() {
        System.out.println("\n--- All Students & Courses ---");
        for (Map.Entry<Integer, List<String>> entry : studentCourses.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " | Courses: " + entry.getValue());
        }
    }

    // 7. Save courses to a file (courses.txt)
    private static void saveToFile() {
        try (PrintWriter writer = new PrintWriter("courses.txt")) {
            for (Map.Entry<Integer, List<String>> entry : studentCourses.entrySet()) {
                writer.println("Student ID: " + entry.getKey() + " | Courses: " + entry.getValue());
            }
            System.out.println("Courses saved to 'courses.txt' successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file!");
        }
    }
}

