package model;

public class CurrentAccount extends Account {

    public CurrentAccount(int accountNumber, double balance) {

        super(accountNumber, balance);

    }

    @Override
    public void deposit(double amount) {

        balance += amount;

        System.out.println("Deposit Successful.");

    }

    @Override
    public void withdraw(double amount) {

        balance -= amount;

        System.out.println("Withdraw Successful.");

    }

}