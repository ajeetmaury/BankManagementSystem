package main;

import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;
import service.BankService;

public class Main {

    public static void main(String[] args) {

        BankService bank = new BankService();

        Account account1 = new SavingsAccount(
                101,
                10000);

        Account account2 = new CurrentAccount(
                102,
                25000);

        Account account3 = new SavingsAccount(
                103,
                5000);

        bank.addAccount(account1);

        bank.addAccount(account2);

        bank.addAccount(account3);

        bank.showAllAccounts();

        Account account = bank.findAccount(102);

        if (account != null) {

            System.out.println("\nAccount Found");

            System.out.println(
                    account.getAccountNumber());

            account.displayBalance();

        }

    }

}