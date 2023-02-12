package api.customers.repository;

import api.customers.entity.Account;
import api.customers.entity.Customer;
import api.customers.entity.Transaction;
import api.customers.entity.TransactionType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements  CustomerRepository{

    private List<Customer> customers = new ArrayList<>();

    public CustomerRepositoryImpl() {
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

    @Override
    public Customer findCustomerById(int customerId) {
        return customers.stream().filter(customer -> customer.getCustomerId() == customerId).findFirst().orElse(null);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }
}
