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

        Account account1 = new Account(1);
        account1.addTransaction(new Transaction("T0001", "Salary", 5000, TransactionType.BUY));
        account1.addTransaction(new Transaction("T0002", "Shopping", 300, TransactionType.BUY));
        account1.addTransaction(new Transaction("T0003", "Shopping Sell", 300, TransactionType.SELL));

        this.accounts.add(account);
        this.accounts.add(account1);
    }

    @Override
    public Account createAccount(int customerId) {
        Account account = new Account(customerId);
        this.accounts.add(account);
        return account;
    }

    @Override
    public void addTransaction(Account account, double amount) {

    }

    @Override
    public Account findAccountById(int customerId) {
        return accounts.stream().filter(account -> account.getAccountNumber() == customerId).findFirst().orElse(null);
    }

    @Override
    public void saveAccount(Account account) {
    }

    @Override
    public List<Account> findAll() {
        return accounts;
    }
}
