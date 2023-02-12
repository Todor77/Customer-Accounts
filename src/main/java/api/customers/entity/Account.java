package api.customers.entity;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private int accountNumber;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
