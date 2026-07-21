package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.Admin;
import model.Customer;

public class LoginService {

    private Admin admin;

    private List<Customer> customers;

    public LoginService() {

        admin = new Admin(
                "admin",
                "admin123");

        customers = new ArrayList<>();

    }

    public void addCustomer(Customer customer) {

        customers.add(customer);

    }

    public boolean adminLogin(
            String username,
            String password) {

        return admin.getUsername().equals(username)
                &&
                admin.getPassword().equals(password);

    }

    public Customer customerLogin(
            String username,
            String password) {

        for (Customer customer : customers) {

            if (customer.getUsername().equals(username)
                    &&
                    customer.getPassword().equals(password)) {

                return customer;

            }

        }

        return null;

    }

    public Collection<Customer> getAllCustomers() {

        return customers;

    }

    public void loadCustomer(Customer customer) {

        customers.add(customer);

    }

}