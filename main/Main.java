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

        bank.withdraw(101, 500000);

        System.out.println("\nDeposit 5000 into Account 101");

        bank.deposit(101, 5000);

        System.out.println();

        System.out.println("Withdraw 3000 from Account 101");

        bank.withdraw(101, 3000);

        System.out.println();

        Account account = bank.findAccount(101);

        if (account != null) {

            account.displayBalance();

            account.displayTransactions();

        }

    }

}