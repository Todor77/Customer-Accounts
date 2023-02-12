package api.customers.repository;

import api.customers.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements  CustomerRepository{

    @Override
    public Customer findCustomerById(int customerId) {
        return null;
    }

    @Override
    public void saveCustomer(Customer customer) {

    }

    @Override
    public List<Customer> findAll() {
        return null;
    }
}
