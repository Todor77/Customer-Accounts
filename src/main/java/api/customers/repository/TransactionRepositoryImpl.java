package api.customers.repository;

import api.customers.entity.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    @Override
    public void addTransaction(String transactionId) {

    }

    @Override
    public void deleteTransaction(String transactionId) {

    }

    @Override
    public Transaction findById(String transactionId) {
        return null;
    }

    @Override
    public Transaction findTransactionByAccount(int accountId) {
        return null;
    }
}
