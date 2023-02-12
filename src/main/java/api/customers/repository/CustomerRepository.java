package api.customers.repository;

import api.customers.entity.Customer;

import java.util.List;

public interface CustomerRepository {

    Customer findCustomerById(int customerId);

    void saveCustomer(Customer customer);

    List<Customer> findAll();
}
