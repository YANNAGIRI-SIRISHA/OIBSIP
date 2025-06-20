public class BankAccount {
    private String userId;
    private String pin;
    private double balance;
    private StringBuilder transactionHistory;

    public BankAccount(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new StringBuilder("Transaction History:\n");
    }

    public boolean authenticate(String enteredId, String enteredPin) {
        return this.userId.equals(enteredId) && this.pin.equals(enteredPin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.append("Deposited: ₹").append(amount).append("\n");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.append("Withdrew: ₹").append(amount).append("\n");
            return true;
        }
        return false;
    }

    public boolean transfer(double amount, String toUser) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.append("Transferred ₹").append(amount).append(" to ").append(toUser).append("\n");
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getTransactionHistory() {
        return transactionHistory.toString();
    }
}
