package api.customers.service;

import api.customers.controller.request.CustomerAccountRequest;
import api.customers.entity.Account;
import api.customers.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CustomerService customerService;

    @Test
    public void testOpenAccount() throws Exception {
        int customerId = 2;
        int initialAmount = 100;

        // Create the request object
        CustomerAccountRequest request = new CustomerAccountRequest();
        request.setCustomerId(customerId);
        request.setInitialAmount(initialAmount);

        // Send the request to the endpoint
        ResponseEntity<String> response = restTemplate.postForEntity("/v2/openAccount", request, String.class);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Account opened for customer with ID: " + customerId, response.getBody());

        // Verify that the account was opened
        Optional<Customer> customer = customerService.findById(customerId);
        assertNotNull(customer);
        Account account = customer.get().getAccount();
        assertNotNull(account);
        assertNotNull(account.getTransactions());
    }
}
