import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
    private double balance;
    private List<String> transactionHistory;

    private String name;

    public Account(String name) {
        balance = 0.0;
        transactionHistory = new ArrayList<>();
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public String getName() {
        return name;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: Rs" + amount);
            System.out.println("Deposited: Rs" + amount);
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: Rs" + amount);
            System.out.println("Withdrawn: Rs" + amount);
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.add("Transferred: Rs" + amount + " to " + recipient.getName());
            System.out.println("Transferred: Rs" + amount + " to " + recipient.getName());
        } else {
            System.out.println("Invalid amount or insufficient funds for transfer.");
        }
    }
}

class ATM {
    public static void main(String[] args) {
        Account account1 = new Account("Aman");
        Account account2 = new Account("Ayush");

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Check Balance");
            System.out.println("5. Show Transaction History");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: Rs");
                    double depositAmount = scanner.nextDouble();
                    account1.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: Rs");
                    double withdrawalAmount = scanner.nextDouble();
                    account1.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.print("Enter transfer amount: Rs");
                    double transferAmount = scanner.nextDouble();
                    account1.transfer(account2, transferAmount);
                    break;
                case 4:
                    System.out.println("Your balance: Rs" + account1.getBalance());
                    break;
                case 5:
                    List<String> history = account1.getTransactionHistory();
                    System.out.println("Transaction History:");
                    for (String transaction : history) {
                        System.out.println(transaction);
                    }
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }
}
