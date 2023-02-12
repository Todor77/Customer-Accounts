package api.customers.repository;

import api.customers.entity.Account;

import java.util.List;

public interface AccountRepository {
    Account createAccount(int customerId);

    void addTransaction(Account account, double amount);

    Account findAccountById(int accountId);

    void saveAccount(Account account);

    List<Account> findAll();
}
