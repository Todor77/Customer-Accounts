package api.customers.repository;

import api.customers.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository{

    @Override
    public Account createAccount(int customerId) {
        return null;
    }

    @Override
    public void addTransaction(Account account, double amount) {

    }

    @Override
    public Account findAccountById(int accountId) {
        return null;
    }

    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public List<Account> findAll() {
        return null;
    }
}
