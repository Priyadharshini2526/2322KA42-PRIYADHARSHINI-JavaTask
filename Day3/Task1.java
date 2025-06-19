package Day3;
public class Task1 {
    double balance = 1000; // Starting balance

    void deposit(double amt) {
        balance += amt;
        System.out.println("Deposited: ₹" + amt);
    }

    void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawn: ₹" + amt);
        } else {
            System.out.println("Not enough balance!");
        }
    }

    void show() {
        System.out.println("Balance: ₹" + balance);
    }

    public static void main(String[] args) {
        Task1 acc = new Task1(); // Create object
        acc.deposit(500); // Deposit money
        acc.withdraw(300); // Withdraw money
        acc.show(); // Show final balance
    }
}
