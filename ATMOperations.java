import java.util.Scanner;

public class ATMOperations {
    private BankAccount account;
    private Scanner scanner;

    public ATMOperations(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nSelect Option:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.println(account.getTransactionHistory());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance or invalid amount.");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;
                case 4:
                    System.out.print("Enter recipient user ID: ");
                    String toUser = scanner.next();
                    System.out.print("Enter amount to transfer: ₹");
                    double transferAmount = scanner.nextDouble();
                    if (account.transfer(transferAmount, toUser)) {
                        System.out.println("Transfer successful.");
                    } else {
                        System.out.println("Insufficient balance or invalid amount.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
