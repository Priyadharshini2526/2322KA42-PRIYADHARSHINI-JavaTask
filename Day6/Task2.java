package Day6;
//Define a class that implements Runnable
class Task2 implements Runnable {
 private String message;

 // Constructor to set the message
 public Task2(String message) {
     this.message = message;
 }

 // Override the run() method
 public void run() {
     // Print the message 5 times
     for (int i = 1; i <= 5; i++) {
         System.out.println(Thread.currentThread().getName() + ": " + message);
         try {
             Thread.sleep(300); // Pause for 300ms
         } catch (InterruptedException e) {
             System.out.println("Thread interrupted");
         }
     }
 }

 // Main method to start multiple threads
 public static void main(String[] args) {
     // Create Runnable instances with different messages
     Runnable task1 = new Task2("Hello from Thread 1");
     Runnable task2 = new Task2("Greetings from Thread 2");
     Runnable task3 = new Task2("Welcome from Thread 3");

     // Create Thread objects and start them
     Thread thread1 = new Thread(task1, "Thread-1");
     Thread thread2 = new Thread(task2, "Thread-2");
     Thread thread3 = new Thread(task3, "Thread-3");

     thread1.start();
     thread2.start();
     thread3.start();
 }
}