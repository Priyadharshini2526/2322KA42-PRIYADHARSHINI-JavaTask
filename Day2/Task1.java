package Day2;
import java.util.Scanner;

public class Task1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int a = scanner.nextInt();
        int[] numbers = new int[a];
        System.out.println("Enter the numbers: ");
        for (int i = 0; i < a; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println("Reversed array: ");
        for (int i = a - 1; i >= 0; i--) {
            System.out.println(numbers[i] + " ");
        }
        scanner.close();
    }
}