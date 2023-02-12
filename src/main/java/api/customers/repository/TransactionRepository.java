package api.customers.repository;


import api.customers.entity.Transaction;
import api.customers.entity.TransactionType;

public interface TransactionRepository {

    Transaction addTransaction(String transactionId, String description, double amount, TransactionType transactionType);

    void deleteTransaction(String transactionId);

    Transaction findById(String transactionId);

    Transaction findTransactionByAccount(int accountId);
}