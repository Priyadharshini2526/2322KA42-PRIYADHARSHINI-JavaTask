package Day6;
class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized withdraw method
    public synchronized void withdraw(int amount) {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " is trying to withdraw ₹" + amount);

        // Simulate processing delay
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted.");
        }

        if (balance >= amount) {
            balance -= amount;
            System.out.println(threadName + " successfully withdrew ₹" + amount);
        } else {
            System.out.println(threadName + " failed to withdraw ₹" + amount + " (Insufficient Balance)");
        }

        System.out.println("Remaining balance: ₹" + balance + "\n");
    }

    public int getBalance() {
        return balance;
    }
}

class User extends Thread {
    private BankAccount account;
    private int amount;

    public User(BankAccount account, int amount, String name) {
        super(name);
        this.account = account;
        this.amount = amount;
    }

    public void run() {
        account.withdraw(amount);
    }
}

public class Task5 {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(5000); // Initial balance

        // Creating multiple users (threads)
        User u1 = new User(sharedAccount, 2000, "User-A");
        User u2 = new User(sharedAccount, 3000, "User-B");
        User u3 = new User(sharedAccount, 1500, "User-C");

        u1.start();
        u2.start();
        u3.start();
    }
}
