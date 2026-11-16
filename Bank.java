import java.util.ArrayList;

public class Bank implements HasMenu {
    private Admin admin;
    private ArrayList<Customer> customers;

    public Bank() {
        admin = new Admin();
        customers = new ArrayList<>();
    }

    public static void main(String[] args) {
        new Bank().start();
    }

    public void loadSampleCustomers() {
        customers.clear();
        customers.add(new Customer());
        customers.add(new Customer("Bob", "8845"));
        customers.add(new Customer("Cindy", "9924"));
    }

    public void fullCustomerReport() {
        System.out.println("Full customer report");
        for (Customer c : customers) {
            System.out.println(c.getReport());
        }
    }

    public void addUser() {
        System.out.println("Add User");
        System.out.print("Name: ");
        String name = CheckingAccount.in.next();
        for (Customer c : customers) {
            if (c.getUserName().equalsIgnoreCase(name)) {
                System.out.println("That user already exists.");
                return;
            }
        }
        System.out.print("PIN: ");
        String pin = CheckingAccount.in.next();
        customers.add(new Customer(name, pin));
    }

    public void applyInterest() {
        for (Customer c : customers) {
            c.getSavings().calcInterest();
        }
        System.out.println("Interest applied to savings accounts");
    }

    public void loginAsCustomer() {
        System.out.println("Customer login");
        System.out.print("User name: ");
        String name = CheckingAccount.in.next();
        System.out.print("PIN: ");
        String pin = CheckingAccount.in.next();
        for (Customer c : customers) {
            if (c.login(name, pin)) {
                System.out.println("Login Successful");
                c.start();
                return;
            }
        }
        System.out.println("Login failed");
    }

    
    public String menu() {
        return "\nBank Menu\n\n"
             + "0) Exit system\n"
             + "1) Login as admin\n"
             + "2) Login as customer\n\n"
             + "Action: ";
    }

    
    public void start() {
        loadSampleCustomers();
        int choice;
        do {
            System.out.print(menu());
            while (!CheckingAccount.in.hasNextInt()) {
                CheckingAccount.in.next();
                System.out.print("Action: ");
            }
            choice = CheckingAccount.in.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Admin login");
                    if (admin.login()) {
                        startAdmin();
                    } else {
                        System.out.println("Login failed");
                    }
                }
                case 2 -> loginAsCustomer();
                case 0 -> System.out.println("Byebye!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public void startAdmin() {
        int choice;
        do {
            System.out.print(admin.menu());
            while (!CheckingAccount.in.hasNextInt()) {
                CheckingAccount.in.next();
                System.out.print("Action: ");
            }
            choice = CheckingAccount.in.nextInt();
            switch (choice) {
                case 1 -> fullCustomerReport();
                case 2 -> addUser();
                case 3 -> applyInterest();
                case 0 -> System.out.println("Admin logged out.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
