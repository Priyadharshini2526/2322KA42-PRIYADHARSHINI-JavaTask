package Day1;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amt :");
        double p = scanner.nextDouble();
        System.out.println("Enter the rate :");
        double r = scanner.nextDouble();
        System.out.println("Enter the year :");
        double y = scanner.nextDouble();
        if (p > 0 && y > 0 && r > 0) {
            double percent = (p * y * r) / 100;
            System.out.println("SI percentage:" + percent);
        }
    }
}
