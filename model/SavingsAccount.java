package model;

import exception.InsufficientBalanceException;

public class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber, double balance) {

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

        if (amount > balance) {

            throw new InsufficientBalanceException(
                    "Insufficient Balance.");

        }

        balance -= amount;

        addTransaction(
                "Withdraw",
                amount);

        System.out.println("Withdraw Successful.");

    }

}