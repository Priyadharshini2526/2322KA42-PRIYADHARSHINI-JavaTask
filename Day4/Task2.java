package Day4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        try {
            File file = new File("sample.txt"); // Make sure this file exists
            Scanner reader = new Scanner(file);

            System.out.println("Contents of the file:");
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check the file name or path.");
        }
    }
}


