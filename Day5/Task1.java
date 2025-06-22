package Day5;
import java.util.ArrayList;
import java.util.Iterator;

class Student {
    String name;
    int rollNo;
    int age;

    // Constructor
    Student(String name, int rollNo, int age) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
    }

    // toString method for easy display
    public String toString() {
        return "Name: " + name + ", Roll No: " + rollNo + ", Age: " + age;
    }
}

public class Task1{
    public static void main(String[] args) {
        // Creating ArrayList of Students
        ArrayList<Student> students = new ArrayList<>();

        // Adding student objects
        students.add(new Student("Alice", 1, 20));
        students.add(new Student("Bob", 2, 21));
        students.add(new Student("Charlie", 3, 22));

        // Display using Iterator
        Iterator<Student> iterator = students.iterator();

        System.out.println("Student List:");
        while (iterator.hasNext()) {
            Student s = iterator.next();
            System.out.println(s); // Calls toString method
        }
    }
}