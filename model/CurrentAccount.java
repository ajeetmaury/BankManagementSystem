package model;

import exception.InsufficientBalanceException;

public class CurrentAccount extends Account {

    public CurrentAccount(int accountNumber, double balance) {

        super(accountNumber, balance);

    }

    @Override
    public void deposit(double amount) {

        balance += amount;

        addTransaction(
                "Deposit",
                amount);

        System.out.println("Deposit Successful.");

    }

    @Override
    public void withdraw(double amount)
            throws InsufficientBalanceException {

        balance -= amount;

        addTransaction(
                "Withdraw",
                amount);

        System.out.println("Withdraw Successful.");

    }

}