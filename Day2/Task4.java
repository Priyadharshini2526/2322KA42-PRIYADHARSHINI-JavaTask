package Day2;
import java.util.Scanner;
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String input = scanner.nextLine();
        String[] words = input.trim().split("\\s+");
        int wordCount = words.length;
        int charCount = input.replace(" ", "").length();
        String reversed = new StringBuilder(input).reverse().toString();
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("\n-----Analysis-----");
        System.out.println("Word count: " + wordCount);
        System.out.println("Character count (excluding spaces): " + charCount);
        System.out.println("Reversed string: " + reversed);
        System.out.println("Longest word: " + longestWord);
    }
}
