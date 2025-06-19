package Day3;
// Base class
class Person {
    String name;
    int age;

    // Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Display person details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Derived class
class Employee extends Person {
    double salary;

    // Constructor
    Employee(String name, int age, double salary) {
        super(name, age); // Call constructor of Person
        this.salary = salary;
    }

    // Method to increase salary
    void increaseSalary(double amount) {
        salary += amount;
        System.out.println("Salary increased by " + amount);
    }

    // Display employee details
    @Override
    void displayDetails() {
        super.displayDetails(); // Call parent method
        System.out.println("Salary: ₹" + salary);
    }
}

// Main class
public class Task2 {
    public static void main(String[] args) {
        Employee emp = new Employee("Ravi", 30, 35000);
        emp.displayDetails();

        System.out.println("\nUpdating salary...");
        emp.increaseSalary(5000);
        
        System.out.println("\nUpdated details:");
        emp.displayDetails();
    }
}
