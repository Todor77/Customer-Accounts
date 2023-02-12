package api.customers.service;


import api.customers.entity.Account;
import api.customers.entity.Transaction;
import api.customers.entity.TransactionType;
import api.customers.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void createTransaction(Account account, String description, double amount, TransactionType transactionType) {
        account.addTransaction(new Transaction("T" + System.currentTimeMillis(), description, amount, transactionType));
    }
}