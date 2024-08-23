class Account {
    private String accountNumber, accountHolderName, bankName;
    private double accountBalance;

    public Account(String accountNumber, String accountHolderName, double accountBalance, String bankName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void displayAccountType() {
        System.out.println("This is a general account.");
    }

    public void display() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Balance: " + accountBalance + "\n");
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, String accountHolderName, double accountBalance, String bankName) {
        super(accountNumber, accountHolderName, accountBalance, bankName);
    }

    public void applyInterest(double interestRate) {
        setAccountBalance(getAccountBalance() + getAccountBalance() * (interestRate / 100));
    }

    @Override
    public void displayAccountType() {
        System.out.println("This is a Savings Account.");
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(String accountNumber, String accountHolderName, double accountBalance, String bankName) {
        super(accountNumber, accountHolderName, accountBalance, bankName);
    }

    public void chargeMaintenanceFee(double fee) {
        setAccountBalance(getAccountBalance() - fee);
    }

    @Override
    public void displayAccountType() {
        System.out.println("This is a Current Account.");
    }
}

class Transaction {
    public void deposit(Account account, double amount) {
        if (amount > 0) {
            account.setAccountBalance(account.getAccountBalance() + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(Account account, double amount) {
        if (amount > 0) {
            if (account.getAccountBalance() < amount) {
                System.out.println("Insufficient balance");
            } else {
                account.setAccountBalance(account.getAccountBalance() - amount);
            }
        } else {
            System.out.println("Withdraw amount must be positive.");
        }
    }

    public void performTransaction(Account account) {
        account.displayAccountType();
        account.display();
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {
        Account sa = new SavingsAccount("1", "Sriram", 1000, "SBI Bank");
        Account ca = new CurrentAccount("2", "Ravi", 5000, "Kotak Bank");

        Transaction t = new Transaction();

        // Savings Account Transactions
        t.deposit(sa, 500); // Deposit 500
        //((SavingsAccount) sa).applyInterest(5); // Apply 5% interest
        t.withdraw(sa, 1000); // Withdraw 1000
        t.performTransaction(sa);

        // Current Account Transactions
        t.deposit(ca, 1000); // Deposit 1000
        //((CurrentAccount) ca).chargeMaintenanceFee(100); // Charge maintenance fee
        t.withdraw(ca, 4000); // Withdraw 4000
        t.performTransaction(ca);
    }
}
