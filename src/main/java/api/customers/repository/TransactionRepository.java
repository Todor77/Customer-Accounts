package api.customers.repository;


import api.customers.entity.Transaction;

public interface TransactionRepository {

    void addTransaction(String transactionId);

    void deleteTransaction(String transactionId);

    Transaction findById(String transactionId);

    Transaction findTransactionByAccount(int accountId);
}