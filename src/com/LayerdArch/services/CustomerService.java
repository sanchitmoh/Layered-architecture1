package com.LayerdArch.services;

import com.LayerdArch.model.Customer;
import com.LayerdArch.repository.CustomerRepository;

import java.util.List;
import java.time.LocalDate;

public class CustomerService {

    // Initialize the CustomerRepository
    CustomerRepository customerRepository = new CustomerRepository();

    // Add a new customer with the current date of joining
    public String addCustomer(Customer customer) {
        customer.setDateOfJoin(LocalDate.now()); // Set the date of joining to the current date
        return customerRepository.addCustomer(customer); // Add the customer using the repository
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers(); // Call the repository method
    }

    // Get a customer by ID
    public Customer getCustomer(int id) {
        return customerRepository.getCustomer(id); // Get the customer using the repository
    }

    // Update a customer by ID
    public String updateCustomer(Customer updatedCustomer, int id) {
        return customerRepository.updateCustomer(updatedCustomer, id); // Update the customer using the repository
    }

    // Delete a customer by ID
    public String deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id); // Delete the customer using the repository
    }
}



