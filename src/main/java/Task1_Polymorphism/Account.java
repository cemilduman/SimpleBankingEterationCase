package Task1_Polymorphism;

import java.util.HashSet;
import java.util.Set;

public class Account {
    private String owner;
    private String accountNumber;
    private double balance = 0;
    Set<Transaction> transactions = new HashSet<>();

    public Account(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
    }

    public void credit(double amount){
        this.balance += amount;
    }

    public void debit(double amount){
        this.balance -= amount;
    }

    public void post(WithdrawalTransaction transaction){
        this.debit(transaction.getAmount());
        this.transactions.add(transaction);
    }

    public void post(DepositTransaction transaction){
        this.credit(transaction.getAmount());
        this.transactions.add(transaction);
    }

    public double getBalance() {
        return balance;
    }
}
