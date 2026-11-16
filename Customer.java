public class Customer extends User {
    private CheckingAccount checking;
    private SavingsAccount savings;

    public Customer() {
        super("Alice", "0000");
        checking = new CheckingAccount(1000.0);
        savings = new SavingsAccount(1000.0, 0.02);
    }

    public Customer(String userName, String PIN) {
        super(userName, PIN);
        checking = new CheckingAccount(0.0);
        savings = new SavingsAccount(0.0, 0.02);
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        if (customer.login()) {
            System.out.println("Login Successful");
            customer.start();
        } else {
            System.out.println("Login failed");
        }
    }

    public CheckingAccount getChecking() {
        return checking;
    }

    public SavingsAccount getSavings() {
        return savings;
    }

    public String menu() {
        return "\nCustomer Menu\n\n"
             + "0) Exit\n"
             + "1) Manage Checking Account\n"
             + "2) Manage Savings Account\n"
             + "3) change PIN\n\n"
             + "Action (0-3): ";
    }

    public void start() {
        int choice;
        do {
            System.out.print(menu());
            while (!CheckingAccount.in.hasNextInt()) {
                CheckingAccount.in.next();
                System.out.print("Action (0-3): ");
            }
            choice = CheckingAccount.in.nextInt();
            switch (choice) {
                case 1 -> checking.start();
                case 2 -> savings.start();
                case 3 -> changePIN();
                case 0 -> System.out.println("Logged out.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public void changePIN() {
        System.out.print("New PIN: ");
        setPIN(CheckingAccount.in.next());
        System.out.println("PIN updated.");
    }


    public String getReport() {
        return "User: " + getUserName()
             + ", Checking: " + checking.getBalanceString()
             + ", Savings: " + savings.getBalanceString();
    }
}
