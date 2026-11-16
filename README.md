```mermaid
classDiagram
    class HasMenu {
        <<interface>>
        +menu() String
        +start() void
    }

    class CheckingAccount {
        <<Serializable>>
        -balance: double
        +CheckingAccount()
        +CheckingAccount(balance)
        +main() void
        +menu() String
        +start() String
        +getBalance() double
        +getBalanceString() String
        +setBalance(balance) void
        +checkBalance() void
        -getDouble() double
        +makeDeposit() void
        +makeWithdrawal() void
    }

    class SavingsAccount {
        -interestRate: double
        +main(args) void
        +calcInterest() void
        +setInterestRate() void
        +getInterestRate() void
    }

    class User {
        <<abstract>>
        -userName: String
        -PIN: String
        +login() boolean
        +login(userName, PIN) boolean
        +setUserName(userName) void
        +getUserName() String
        +setPIN(PIN) void
        +getPIN() String
        +getReport()* String
    }

    class Admin {
        +Admin()
        +menu() String
        +getReport() String
    }

    class Customer {
        <<Serializable>>
        -checking: CheckingAccount
        -savings: SavingsAccount
        +main() void
        +Customer()
        +start() void
        +menu() String
        +changePIN() void
        +getReport() String
    }

    class Bank {
        -admin: Admin
        -customers: ArrayList
        +Bank()
        +main() void
        +loadSampleCustomers() void
        +loadCustomers() void
        +saveCustomers() void
        +fullCustomerReport() void
        +addUser() void
        +applyInterest() void
        +loginAsCustomer() void
        +menu() void
        +start() void
        +startAdmin() void
    }

    HasMenu <|.. CheckingAccount : Implements
    HasMenu <|.. User : Implements
    CheckingAccount <|-- SavingsAccount : Extends
    User <|-- Admin : Extends
    User <|-- Customer : Extends
    Bank "1" o--> Admin
    Bank "n" o--> Customer
```
