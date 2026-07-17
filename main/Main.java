package main;

import model.Customer;
import model.Account;
import model.SavingsAccount;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer(
                1,
                "Ajeet Kumar",
                21,
                "9876543210");

        customer.displayCustomer();

        System.out.println();

        Account account = new SavingsAccount(
                101,
                10000);

        account.displayBalance();

        account.deposit(5000);

        account.withdraw(2000);

        account.displayBalance();

    }

}