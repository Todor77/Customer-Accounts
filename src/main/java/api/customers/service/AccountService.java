package api.customers.service;

import api.customers.entity.Account;
import api.customers.entity.TransactionType;
import api.customers.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final TransactionService transactionService;
    private final AccountRepository accountRepository;

    public AccountService(TransactionService transactionService, AccountRepository accountRepository) {
        this.transactionService = transactionService;
        this.accountRepository = accountRepository;
    }

    public Account createAccount(int customerId) {
        return accountRepository.createAccount(customerId);
    }

    public void addTransaction(Account account, String description, double amount, TransactionType transactionType) {
        transactionService.createTransaction(account, description, amount, transactionType);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Optional<Account> findById (int accountId) {
        return Optional.ofNullable(accountRepository.findAccountById(accountId));
    }
}
