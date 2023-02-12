package api.customers.repository;

import api.customers.entity.Account;
import api.customers.entity.Transaction;
import api.customers.entity.TransactionType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository{

    private List<Account> accounts = new ArrayList<>();

    public AccountRepositoryImpl() {

        Account account = new Account(3);
        account.addTransaction(new Transaction("T0010", "Salary", 2000, TransactionType.BUY));
        account.addTransaction(new Transaction("T0020", "Shopping", 200, TransactionType.BUY));
        account.addTransaction(new Transaction("T0030", "Shopping Sell", 200, TransactionType.SELL));
        this.accounts.add(account);
    }

    @Override
    public Account createAccount(int customerId) {
        return new Account(customerId);
    }

    @Override
    public void addTransaction(Account account, double amount) {

    }

    @Override
    public Account findAccountById(int accountId) {
        return accounts.stream().filter(account -> account.getAccountNumber() == accountId).findFirst().orElse(null);
    }

    @Override
    public void saveAccount(Account account) {
    }

    @Override
    public List<Account> findAll() {
        return accounts;
    }
}
