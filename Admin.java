public class Admin extends User {

    public Admin() {
        super("admin", "9999");
    }


    public String menu() {
        return "\nAdmin Menu\n\n"
             + "0) Exit this menu\n"
             + "1) Full customer report\n"
             + "2) Add user\n"
             + "3) Apply interest to savings accounts\n\n"
             + "Action: ";
    }


    public void start() {
        System.out.print(menu());
    }


    public String getReport() {
        return "Administrator: " + getUserName();
    }
}
