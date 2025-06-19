package Day1;
import java.util.Scanner;
public class Task5 {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.println("Enter marks: ");
int marks = scanner.nextInt();
String grade = calculateGrade (marks);
System.out.println("Grade:" + grade);

}

public static String calculateGrade (int marks) {
	if(marks>=90) return "A+";
else if(marks>=80)return"A";
else if(marks>=70)return"B+";
else if(marks>=60)return"B";
else return "F";
}
}