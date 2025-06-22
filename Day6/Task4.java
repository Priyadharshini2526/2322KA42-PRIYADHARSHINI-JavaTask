package Day6;
class TicketBooking {
    private int availableSeats = 5; // Total available seats

    // Booking method with synchronization
    public void bookTicket(String user, int seatsToBook) {
        synchronized (this) {
            System.out.println(user + " is trying to book " + seatsToBook + " ticket(s)...");

            // Simulate delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }

            // Check seat availability
            if (seatsToBook <= availableSeats) {
                System.out.println("Booking successful for " + user);
                availableSeats -= seatsToBook;
            } else {
                System.out.println("Booking failed for " + user + ". Not enough seats available.");
            }

            // Display remaining seats
            System.out.println("Remaining seats: " + availableSeats);
            System.out.println("----------------------------------");
        }
    }
}

// Thread class representing a user
class UserThread extends Thread {
    private TicketBooking bookingSystem;
    private String userName;
    private int seatsToBook;

    public UserThread(TicketBooking bookingSystem, String userName, int seatsToBook) {
        this.bookingSystem = bookingSystem;
        this.userName = userName;
        this.seatsToBook = seatsToBook;
    }

    public void run() {
        bookingSystem.bookTicket(userName, seatsToBook);
    }
}

// Main class
public class Task4 {
    public static void main(String[] args) {
        TicketBooking bookingSystem = new TicketBooking();

        // Create multiple users trying to book tickets
        UserThread user1 = new UserThread(bookingSystem, "Alice", 2);
        UserThread user2 = new UserThread(bookingSystem, "Bob", 1);
        UserThread user3 = new UserThread(bookingSystem, "Charlie", 3);
        UserThread user4 = new UserThread(bookingSystem, "David", 1);

        // Start threads
        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}

