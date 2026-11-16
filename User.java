import java.io.Serializable;

public abstract class User implements HasMenu, Serializable {
    private String userName;
    private String PIN;

    public User() {
        this("", "");
    }

    public User(String userName, String PIN) {
        this.userName = userName;
        this.PIN = PIN;
    }

    public boolean login() {
        System.out.print("User name: ");
        String name = CheckingAccount.in.next();
        System.out.print("PIN: ");
        String pin = CheckingAccount.in.next();
        return login(name, pin);
    }

    public boolean login(String userName, String PIN) {
        return this.userName.equalsIgnoreCase(userName) && this.PIN.equals(PIN);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getPIN() {
        return PIN;
    }

    public abstract String getReport();
}


