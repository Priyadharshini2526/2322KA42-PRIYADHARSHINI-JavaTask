package Day6;
//Create a class that extends Thread
class Task1 extends Thread {
 public void run() {
     // Print numbers from 1 to 10
     for (int i = 1; i <= 10; i++) {
         System.out.println(i);
         try {
             // Sleep for 500 milliseconds to slow down the output
             Thread.sleep(500);
         } catch (InterruptedException e) {
             System.out.println("Thread interrupted");
         }}}
public static void main(String[] args) {
     // Create an object of the thread class
     Task1 thread = new Task1();
     // Start the thread
     thread.start();
 }}