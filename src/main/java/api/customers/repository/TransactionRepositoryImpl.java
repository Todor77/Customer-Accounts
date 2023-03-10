package api.customers.repository;

import api.customers.entity.Transaction;
import api.customers.entity.TransactionType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private List<Transaction> transactions = new ArrayList();

    public TransactionRepositoryImpl() {

        Transaction transaction = new Transaction("B0001", "Salary", 5000, TransactionType.BUY);
        Transaction transaction1 = new Transaction("B0002", "Shopping", 300, TransactionType.BUY);
        Transaction transaction2 = new Transaction("B0003", "Shopping Sell", 300, TransactionType.SELL);

        transactions.add(transaction);
        transactions.add(transaction1);
        transactions.add(transaction2);
    }

    @Override
    public Transaction addTransaction(String transactionId, String description, double amount, TransactionType transactionType) {
        Transaction transaction = new Transaction("T" + System.currentTimeMillis(), description, amount, transactionType);
        transactions.add(transaction);
        return transaction;
    }

    @Override
    public void deleteTransaction(String transactionId) {

    }

    @Override
    public Transaction findById(String transactionId) {
        return transactions.stream().filter(transaction -> transaction.getTransactionId() == transactionId).findFirst().orElse(null);
    }

    @Override
    public Transaction findTransactionByAccount(int accountId) {
        return null;
    }
}
