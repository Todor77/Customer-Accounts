package api.customers.controller;

import api.customers.entity.Customer;
import api.customers.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }


    @PostMapping("/openAccount")
    public ResponseEntity<String> openAccount(@RequestParam("customerId") int customerId,
                                              @RequestParam("initialCredit") double initialCredit) {
        try {
            customerService.openAccount(customerId, initialCredit);
            return new ResponseEntity<>("Account opened for customer with ID: " + customerId, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
