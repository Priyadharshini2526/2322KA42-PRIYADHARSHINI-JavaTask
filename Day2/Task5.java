package Day2;
import java.util.Scanner;
public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] contacts = new String[5];
        int count = 0;

        while (true) {
            System.out.println("Address Book");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    if (count < 5) {
                        System.out.print("Enter contact: ");
                        contacts[count] = sc.nextLine();
                        count++;
                        System.out.println("Added!");
                    } else {
                        System.out.println("Full!");
                    }
                    break;
                case 2:
                    System.out.println("Contacts:");
                    for (int i = 0; i < count; i++) {
                        System.out.println(contacts[i]);
                    }
                    break;
                case 3:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Invalid!");
            }
        }
    }
}
