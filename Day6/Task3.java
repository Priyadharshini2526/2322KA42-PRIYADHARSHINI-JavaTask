package Day6;
class Task3 extends Thread {
    private String threadName;

    Task3(String name) {
        this.threadName = name;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + ": " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted");
            }
        }
        System.out.println(threadName + " finished.");
    }

    public static void main(String[] args) {
        // Create two threads
        Task3 t1 = new Task3("Thread-1");
        Task3 t2 = new Task3("Thread-2");

        // Start the first thread
        t1.start();

        try {
            // Main thread waits for t1 to finish before starting t2
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        // Start the second thread after t1 finishes
        t2.start();
    }
}

