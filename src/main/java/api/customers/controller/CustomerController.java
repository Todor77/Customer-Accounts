package api.customers.controller;

import api.customers.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class CustomerController {

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return Collections.singletonList(new Customer(1));
    }
}
