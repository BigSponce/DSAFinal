package com.keyin.customer;

import com.keyin.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long id) {
        customerService.removeCustomerById(id);
        return ResponseEntity.ok("Customer with ID " + id + " removed successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomerById(@PathVariable Long id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
        return ResponseEntity.ok("Customer with ID " + id + " updated successfully");
    }
}