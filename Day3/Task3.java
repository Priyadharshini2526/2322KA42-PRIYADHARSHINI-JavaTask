package Day3;
public class Task3  {

    // Method 1: Sum of two integers
    int sum(int a, int b) {
        return a + b;
    }

    // Method 2: Sum of two doubles
    double sum(double a, double b) {
        return a + b;
    }

    // Main method
    public static void main(String[] args) {
        Task3 calc = new Task3();

        int intResult = calc.sum(10, 20); // calls sum(int, int)
        double doubleResult = calc.sum(12.5, 7.5); // calls sum(double, double)

        System.out.println("Sum of integers: " + intResult);
        System.out.println("Sum of doubles: " + doubleResult);
    }
}
