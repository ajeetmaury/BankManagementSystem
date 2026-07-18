package service;

import java.util.HashMap;
import java.util.Map;

import model.Account;
import exception.InsufficientBalanceException;

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

    // ------------------------

    public void deposit(int accountNumber, double amount) {

        Account account = findAccount(accountNumber);

        if (account == null) {

            System.out.println("Account not found.");
            return;

        }

        if (amount <= 0) {

            System.out.println("Invalid deposit amount.");
            return;

        }

        account.deposit(amount);

        System.out.println("Deposit completed successfully.");

    }

    // --------------------
    public void withdraw(int accountNumber, double amount) {

        Account account = findAccount(accountNumber);

        if (account == null) {

            System.out.println("Account not found.");
            return;

        }

        if (amount <= 0) {

            System.out.println("Invalid withdrawal amount.");
            return;

        }

        try {

            account.withdraw(amount);

            System.out.println("Withdrawal completed successfully.");

        } catch (InsufficientBalanceException e) {

            System.out.println(e.getMessage());

        }

    }

    // add Transfer() -----------------------------

    public void transfer(int fromAccountNumber,
            int toAccountNumber,
            double amount) {

        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        if (fromAccount == null) {
            System.out.println("Sender account not found.");
            return;
        }

        if (toAccount == null) {
            System.out.println("Receiver account not found.");
            return;
        }

        if (amount <= 0) {
            System.out.println("Invalid transfer amount.");
            return;
        }

        try {

            fromAccount.withdraw(amount);

            toAccount.deposit(amount);

            fromAccount.addTransaction("Transfer Out", amount);

            toAccount.addTransaction("Transfer In", amount);

            System.out.println("Transfer completed successfully.");

        } catch (InsufficientBalanceException e) {

            System.out.println(e.getMessage());

        }

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