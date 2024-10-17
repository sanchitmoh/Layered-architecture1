package com.LayerdArch.controller;

import com.LayerdArch.model.Customer;
import com.LayerdArch.services.CustomerService; // Assuming this is where the service class is

import java.util.List;
import java.util.Scanner;

// This class represents the controller, which acts as a front-end interface for customer operations
public class CustomerController {
    // Scanner for taking input
    Scanner sc = new Scanner(System.in);

    // Created the CustomerService object (service layer)
    CustomerService customerService = new CustomerService();

    // Method to add a customer
    public String addCustomer() {
        System.out.print("Enter name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter email: ");
        String customerEmail = sc.nextLine();

        System.out.print("Enter phone: ");
        String customerPhone = sc.nextLine();

        System.out.print("Enter Banking Account Type: ");
        String bankingAccountType = sc.nextLine();

        // Creating a new Customer object and setting the values
        Customer customer = new Customer();
        customer.setName(customerName);
        customer.setEmail(customerEmail);
        customer.setPhone(customerPhone);
        customer.setAccountType(bankingAccountType);

        // Calling the service layer to add the customer
        return customerService.addCustomer(customer);
    }

    // Method to get all customers
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Method to get a customer by ID
    public Customer getCustomer(int id) {
        return customerService.getCustomer(id);
    }

    // Method to update a customer
    public String updateCustomer(Customer updatedCustomer, int id) {
        // Assuming customerService has a method to update the customer
        return customerService.updateCustomer(updatedCustomer, id);
    }

    // Method to delete a customer
    public String deleteCustomer(int id) {
        // Assuming customerService has a method to delete the customer by ID
        return customerService.deleteCustomer(id);
    }
}
































































