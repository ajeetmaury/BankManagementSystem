package service;

import java.util.HashMap;
import java.util.Map;

import model.Account;

public class BankService {

    // Stores all accounts
    private Map<Integer, Account> accounts;

    public BankService() {
        accounts = new HashMap<>();
    }

    // Add Account
    public void addAccount(Account account) {

        accounts.put(account.getAccountNumber(), account);

        System.out.println(
                "Account " +
                        account.getAccountNumber() +
                        " added successfully.");

    }

    // Find Account
    public Account findAccount(int accountNumber) {

        return accounts.get(accountNumber);

    }

    // Display All Accounts
    public void showAllAccounts() {

        if (accounts.isEmpty()) {

            System.out.println("No Accounts Found.");

            return;

        }

        System.out.println("\n------ Account List ------");

        for (Account account : accounts.values()) {

            System.out.println(
                    "Account Number : "
                            + account.getAccountNumber());

            account.displayBalance();

            System.out.println();

        }

    }

}