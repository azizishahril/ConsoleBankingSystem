import java.util.Scanner;

class BankAccount{
    private String name;
    private double balance;

    public BankAccount(String name) {
        this.name = name;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful!");
        }
    }

    public void displayBalance() {
        System.out.println("Current balance: RM " + balance);
    }

    public String getName() {
        return name;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;
        int choice;

        do {
            System.out.println("\n=== BANK SYSTEM ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // clear buffer
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    account = new BankAccount(name);
                    System.out.println("Account created for " + name);
                    break;

                case 2:
                    if (account == null) {
                        System.out.println("Create account first!");
                        break;
                    }
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    if (account == null) {
                        System.out.println("Create account first!");
                        break;
                    }
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    if (account == null) {
                        System.out.println("Create account first!");
                        break;
                    }
                    account.displayBalance();
                    break;

                case 5:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 5);

        scanner.close();
    }
    
}
