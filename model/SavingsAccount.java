package model;

public class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber, double balance) {

        super(accountNumber, balance);

    }

    @Override
    public void deposit(double amount) {

        balance += amount;

        System.out.println("Deposit Successful.");

    }

    @Override
    public void withdraw(double amount) {

        if (amount <= balance) {

            balance -= amount;

            System.out.println("Withdraw Successful.");

        } else {

            System.out.println("Insufficient Balance.");

        }

    }

}