import java.io.Serializable;
import java.util.Scanner;

public class CheckingAccount implements HasMenu, Serializable {
    protected static final Scanner in = new Scanner(System.in);

    private double balance;

    public CheckingAccount() {
        this(0.0);
    }

    public CheckingAccount(double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount(100.0);
        account.start();
    }

    @Override
    public String menu() {
        return "\nAccount menu\n\n"
             + "0) quit\n"
             + "1) check balance\n"
             + "2) make a deposit\n"
             + "3) make a withdrawal\n"
             + "Choice: ";
    }

    @Override
    public void start() {
        int choice;
        do {
            System.out.print(menu());
            choice = (int) getDouble();
            switch (choice) {
                case 1 -> checkBalance();
                case 2 -> makeDeposit();
                case 3 -> makeWithdrawal();
                case 0 -> { }
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public double getBalance() {
        return balance;
    }

    public String getBalanceString() {
        return String.format("$%.2f", balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void checkBalance() {
        System.out.println("Current balance: " + getBalanceString());
    }

    private double getDouble() {
        while (!in.hasNextDouble()) {
            in.next();
            System.out.print("Enter a number: ");
        }
        return in.nextDouble();
    }

    public void makeDeposit() {
        System.out.print("Deposit amount: ");
        double amount = getDouble();
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        balance += amount;
        checkBalance();
    }

    public void makeWithdrawal() {
        System.out.print("Withdrawal amount: ");
        double amount = getDouble();
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            checkBalance();
        }
    }
}
