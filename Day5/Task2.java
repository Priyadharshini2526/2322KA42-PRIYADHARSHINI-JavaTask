package Day5;
import java.util.HashSet;
import java.util.Iterator;

public class Task2{
    public static void main(String[] args) {
        // Creating a HashSet to store unique email addresses
        HashSet<String> emailSet = new HashSet<>();

        // Adding emails (duplicates will be ignored)
        emailSet.add("priya@example.com");
        emailSet.add("dharshini@example.com");
        emailSet.add("vipin@example.com");
        emailSet.add("illan@example.com"); // Duplicate
        emailSet.add("iniya@example.com");

        // Displaying emails using Iterator
        System.out.println("Unique Email Addresses:");
        Iterator<String> iterator = emailSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

