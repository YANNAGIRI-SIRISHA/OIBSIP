import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount userAccount = new BankAccount("user123", "1234", 1000);

        System.out.println("Welcome to the ATM");
        System.out.print("Enter User ID: ");
        String enteredId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();

        if (userAccount.authenticate(enteredId, enteredPin)) {
            ATMOperations operations = new ATMOperations(userAccount);
            operations.start();
        } else {
            System.out.println("Invalid credentials. Access denied.");
        }

        scanner.close();
    }
}
