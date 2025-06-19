package Day1;
import java.util.Scanner;

public class Task4 {
    // Methods for operations
    public static double add(double a, double b)      { return a + b; }
    public static double subtract(double a, double b) { return a - b; }
    public static double multiply(double a, double b) { return a * b; }
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return Double.NaN;
        }
        return a / b;
    }

    // Displays the menu options
    public static void displayMenu() {
        System.out.println("\n=== Menu-Driven Calculator ===");
        System.out.println("1) Add");
        System.out.println("2) Subtract");
        System.out.println("3) Multiply");
        System.out.println("4) Divide");
        System.out.println("5) Exit");
        System.out.print("Choose an option (1–5): ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        double x = 0, y = 0, result;

        do {
            displayMenu();
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter first number: ");
                x = sc.nextDouble();
                System.out.print("Enter second number: ");
                y = sc.nextDouble();
            }

            switch (choice) {
                case 1:
                    result = add(x, y);
                    System.out.printf("→ Result: %.2f\n", result);
                    break;
                case 2:
                    result = subtract(x, y);
                    System.out.printf("→ Result: %.2f\n", result);
                    break;
                case 3:
                    result = multiply(x, y);
                    System.out.printf("→ Result: %.2f\n", result);
                    break;
                case 4:
                    result = divide(x, y);
                    if (!Double.isNaN(result))
                        System.out.printf("→ Result: %.2f\n", result);
                    break;
                case 5:
                    System.out.println("Exiting—thank you!");
                    break;
                default:
                    System.out.println("Invalid option! Please choose 1–5.");
            }
        } while (choice != 5);

        sc.close();
    }
}
