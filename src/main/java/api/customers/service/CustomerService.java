package api.customers.service;

import api.customers.entity.Account;
import api.customers.entity.Customer;
import api.customers.entity.Transaction;
import api.customers.entity.TransactionType;
import api.customers.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private List<Customer> customers = new ArrayList<>();

    private final AccountService accountService;
    private final CustomerRepository customerRepository;

    public CustomerService(AccountService accountService, CustomerRepository customerRepository) {

        this.accountService = accountService;
        this.customerRepository = customerRepository;
        Customer customer = new Customer(1,"John Doe", 10000);

        Account account = new Account(1);
        account.addTransaction(new Transaction("T0001", "Salary", 5000, TransactionType.BUY));
        account.addTransaction(new Transaction("T0002", "Shopping", 300, TransactionType.BUY));
        account.addTransaction(new Transaction("T0003", "Shopping Sell", 300, TransactionType.SELL));
        customer.setAccount(account);

        Customer customer1 = new Customer(2,"Max Musterman", 0);

        customers.add(customer);
        customers.add(customer1);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(int customerId) {
        return Optional.ofNullable(customerRepository.findCustomerById(customerId));
    }

    public void openAccount(int customerId, double initialCredit) {
        Optional<Customer> customer = findById(customerId);

        customer.ifPresent(c -> {
            Account account = c.getAccount();
            Optional<Account> account1 = accountService.getAccountByCustomerId(c.getCustomerId());
            if (account1.isEmpty()) {
                account = accountService.createAccount(customerId);
            }
            if(initialCredit != 0) {
                accountService.addTransaction(account, "Initial Credit", initialCredit, TransactionType.INITIAL);
            }
            c.setAccount(account);
        });
    }
}
