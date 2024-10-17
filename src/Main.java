import com.LayerdArch.controller.CustomerController;
import com.LayerdArch.model.Customer;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CustomerController customerController = new CustomerController();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the bank account management system");

        while (true) {
            System.out.println("---------------------------Select your operation--------------------------");
            System.out.println("Enter 1: Add Customer");
            System.out.println("Enter 2: Get All Customers");
            System.out.println("Enter 3: Get Customer By ID");
            System.out.println("Enter 4: Update Customer");
            System.out.println("Enter 5: Delete Customer");
            System.out.println("Enter 6: Exit");
            System.out.println("--------------------------------------------------------------------------");

            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    String result = customerController.addCustomer();
                    System.out.println("Customer Addition: " + result);
                    break;

                case 2:
                    List<Customer> customers = customerController.getAllCustomers();
                    if (customers.isEmpty()) {
                        System.out.println("No customers found.");
                    } else {
                        for (Customer customer : customers) {
                            System.out.println(customer);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter the ID for the Customer: ");
                    int id = sc.nextInt();
                    Customer customer = customerController.getCustomer(id);
                    if (customer == null) {
                        System.out.println("Customer with ID " + id + " not found.");
                    } else {
                        System.out.println(customer);
                    }
                    break;

                case 4:
                    System.out.println("Enter the ID of the customer to update: ");
                    int updateId = sc.nextInt();
                    Customer customerToUpdate = customerController.getCustomer(updateId);
                    if (customerToUpdate == null) {
                        System.out.println("Customer with ID " + updateId + " not found.");
                    } else {
                        System.out.println("Enter the updated name: ");
                        String updatedName = sc.next();

                        System.out.println("Enter the updated email: ");
                        String updatedEmail = sc.next();

                        System.out.println("Enter the updated phone: ");
                        String updatedPhone = sc.next();

                        System.out.println("Enter the updated account type: ");
                        String updatedAccountType = sc.next();

                        // Set updated values
                        customerToUpdate.setName(updatedName);
                        customerToUpdate.setEmail(updatedEmail);
                        customerToUpdate.setPhone(updatedPhone);
                        customerToUpdate.setAccountType(updatedAccountType);

                        // Pass updated customer to controller for update
                        String updateResult = customerController.updateCustomer(customerToUpdate, updateId);
                        System.out.println("Update Result: " + updateResult);
                    }
                    break;

                case 5:
                    System.out.println("Enter the ID of the customer to delete: ");
                    int deleteId = sc.nextInt();
                    String deleteResult = customerController.deleteCustomer(deleteId);
                    System.out.println("Delete Result: " + deleteResult);
                    break;

                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0); // Exit the program

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}



