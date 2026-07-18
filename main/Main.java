package main;

import model.Account;
import model.Customer;
import model.SavingsAccount;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer(
                1,
                "Ajeet Kumar",
                20,
                "9876543210");

        customer.displayCustomer();

        System.out.println();

        Account account = new SavingsAccount(
                101,
                10000);

        account.displayBalance();

        account.deposit(5000);

        try {

            account.withdraw(2000);

            account.withdraw(3000);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        account.displayBalance();

        account.displayTransactions();

    }
}