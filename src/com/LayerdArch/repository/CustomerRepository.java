package com.LayerdArch.repository;

import com.LayerdArch.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerRepository {
    // Creating ArrayList to store the customer details, acting as a simple in-memory database
    private static final ArrayList<Customer> customerData = new ArrayList<>();

    // For adding a new customer
    public String addCustomer(Customer customer) {
        customer.setId(getNextId()); // Ensure customer gets a unique ID
        boolean customerAdded = customerData.add(customer);
        String status = customerAdded ? "Added" : "Not Added";
        return status;
    }

    // For getting all customers
    public List<Customer> getAllCustomers() {
        return customerData;
    }


    // For getting a single customer by ID
    public Customer getCustomer(int id) {
        for (Customer customer : customerData) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null; // Return null if not found
    }

    // For updating a customer by ID
    public String updateCustomer(Customer updatedCustomer, int id) {
        for (int i = 0; i < customerData.size(); i++) {
            if (customerData.get(i).getId() == id) {
                customerData.set(i, updatedCustomer); // Update the customer at the specified index
                return "Updated";
            }
        }
        return "Not Updated"; // Return "Not Updated" if customer ID wasn't found
    }

    // For deleting a customer by ID
    public String deleteCustomer(int id) {
        for (int i = 0; i < customerData.size(); i++) {
            if (customerData.get(i).getId() == id) {
                customerData.remove(i); // Remove the customer by index
                return "Deleted";
            }
        }
        return "Not Deleted"; // Return "Not Deleted" if customer ID wasn't found
    }

    // To create a random unique ID
    public int getNextId() {
        Random random = new Random();
        int id;
        do {
            id = 1000 + random.nextInt(90000); // Generate an ID between 1000 and 99999
        } while (findCustomerById(customerData, id) != null); // Ensure the ID is unique
        return id;
    }

    // To find a customer by ID
    public static Customer findCustomerById(List<Customer> customers, int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}


