package model;

import java.util.ArrayList;
import java.util.List;

import exception.InsufficientBalanceException;

public abstract class Account {

    protected int accountNumber;
    protected double balance;

    protected List<Transaction> transactions;

    public Account(int accountNumber, double balance) {

        this.accountNumber = accountNumber;
        this.balance = balance;

        transactions = new ArrayList<>();

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void addTransaction(String type, double amount) {
        transactions.add(new Transaction(type, amount));
    }

    public void displayTransactions() {

        System.out.println();

        System.out.println("Transaction History");

        System.out.println("----------------------------");

        if (transactions.isEmpty()) {

            System.out.println("No Transactions Found.");

            return;

        }

        for (Transaction transaction : transactions) {

            transaction.displayTransaction();

        }

    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount)
            throws InsufficientBalanceException;

    public void displayBalance() {

        System.out.println("Balance : Rs. " + balance);

    }

}