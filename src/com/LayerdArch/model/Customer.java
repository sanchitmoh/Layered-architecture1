package com.LayerdArch.model;

import java.time.LocalDate;

public class Customer {

    // Declare the variables
    private int id;
    private String name;
    private String email;
    private String phone;
    private LocalDate dateOfJoin;
    private String accountType;

    // Default constructor
    public Customer() {
        // Set default account type if not provided
        this.accountType = "Savings"; // You can set any default type here
    }

    // Parameterized constructor
    public Customer(int id, String name, String email, String phone, LocalDate dateOfJoin, String accountType) {
        this.id = id;
        this.name = name;
        setEmail(email); // Using validation in the setter
        setPhone(phone); // Using validation in the setter
        this.dateOfJoin = dateOfJoin;
        this.accountType = (accountType != null && !accountType.isEmpty()) ? accountType : "Savings"; // Default value
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter for email with validation
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        // Simple validation to check if the email contains '@' and has a domain part
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    // Getter and setter for phone with validation
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        // Simple validation for a 10-digit phone number (you can modify based on your needs)
        if (phone != null && phone.matches("\\d{10}")) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Invalid phone number format. Must be a 10-digit number.");
        }
    }

    // Getter and setter for dateOfJoin
    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(LocalDate dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    // Getter and setter for accountType
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        // If accountType is null or empty, set a default value
        this.accountType = (accountType != null && !accountType.isEmpty()) ? accountType : "Savings";
    }

    // Overriding toString() to return customer details as a string
    @Override
    public String toString() {
        return "Customer {" +
                "id=" + id + "," +
                " name=" + name + ", " +
                "email=" + email + ", " +
                "phone=" + phone + ", " +
                "dateOfJoin=" + dateOfJoin + ", " +
                "accountType=" + accountType +
                "}";
    }
}















