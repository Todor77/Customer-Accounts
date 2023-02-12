package api.customers.service;

import api.customers.entity.Customer;
import api.customers.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    private Customer customer;
    private List<Customer> customers;

    @Before
    public void setUp() {
        customer = new Customer(1, "John", 0);
        customers = Arrays.asList(customer);
    }

    @Test
    public void testGetCustomer() {
        when(customerRepository.findCustomerById(1)).thenReturn(customer);
        Customer result = customerService.findById(1).get();
        assertEquals(customer, result);
    }

    @Test
    public void testGetCustomers() {
        when(customerRepository.findAll()).thenReturn(customers);
        List<Customer> result = customerService.findAll();
        assertEquals(customers, result);
    }
}
