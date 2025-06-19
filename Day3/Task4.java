package Day3;
import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    int[] marks = new int[3]; // For 3 subjects

    // Constructor
    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    // Method to assign marks
    void assignMarks(int m1, int m2, int m3) {
        marks[0] = m1;
        marks[1] = m2;
        marks[2] = m3;
    }

    // Method to calculate total
    int getTotalMarks() {
        return marks[0] + marks[1] + marks[2];
    }

    // Method to calculate average
    double getAverage() {
        return getTotalMarks() / 3.0;
    }

    // Method to display student result
    void displayResult() {
        System.out.println("\n--- Student Result ---");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: ");
        System.out.println("Subject 1: " + marks[0]);
        System.out.println("Subject 2: " + marks[1]);
        System.out.println("Subject 3: " + marks[2]);
        System.out.println("Total Marks: " + getTotalMarks());
        System.out.println("Average: " + getAverage());
    }
}

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a student
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();

        Student student = new Student(name, rollNo);

        // Assign marks
        System.out.println("Enter marks for 3 subjects:");
        System.out.print("Subject 1: ");
        int m1 = sc.nextInt();
        System.out.print("Subject 2: ");
        int m2 = sc.nextInt();
        System.out.print("Subject 3: ");
        int m3 = sc.nextInt();

        student.assignMarks(m1, m2, m3);

        // Display result
        student.displayResult();

        sc.close();
    }
}

