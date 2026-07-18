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

        // --------------------
        System.out.println("\nTransfer Rs.3000 from Account 101 to Account 102");

        bank.transfer(101, 102, 3000);

        System.out.println("\n===== Sender Account =====");

        Account sender = bank.findAccount(101);

        if (sender != null) {
            sender.displayBalance();
            sender.displayTransactions();
        }

        System.out.println("\n===== Receiver Account =====");

        Account receiver = bank.findAccount(102);

        if (receiver != null) {
            receiver.displayBalance();
            receiver.displayTransactions();
        }

    }

}