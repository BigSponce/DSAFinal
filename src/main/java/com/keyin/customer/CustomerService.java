package com.keyin.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);

        if (existingCustomer.isPresent()) {
            Customer customerFromDb = existingCustomer.get();

            customerFromDb.setName(customer.getName());
            customerFromDb.setEmail(customer.getEmail());

            return customerRepository.save(customerFromDb);

        } else {
            throw new RuntimeException("Customer not found");
        }
    }

    public void removeCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}