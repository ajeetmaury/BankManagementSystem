package ui;

import java.util.Scanner;

import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;
import service.BankService;

public class BankApplication {

    private Scanner scanner;
    private BankService bankService;

    public BankApplication() {

        scanner = new Scanner(System.in);

        bankService = new BankService();

        initializeAccounts();

    }

    private void initializeAccounts() {

        bankService.addAccount(
                new SavingsAccount(101, 10000));

        bankService.addAccount(
                new CurrentAccount(102, 25000));

        bankService.addAccount(
                new SavingsAccount(103, 5000));

    }

    public void start() {

        boolean running = true;

        while (running) {

            displayMenu();

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    bankService.showAllAccounts();
                    break;

                case 2:
                    depositMoney();
                    break;

                case 3:
                    withdrawMoney();
                    break;

                case 4:
                    transferMoney();
                    break;

                case 5:
                    showTransactions();
                    break;

                case 6:

                    running = false;

                    System.out.println("\nThank You!");

                    break;

                default:

                    System.out.println("\nInvalid Choice!");

            }

        }

        scanner.close();

    }

    private void displayMenu() {

        System.out.println();
        System.out.println("==============================");
        System.out.println(" BANK MANAGEMENT SYSTEM");
        System.out.println("==============================");
        System.out.println("1. Show All Accounts");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Show Transaction History");
        System.out.println("6. Exit");

        System.out.print("\nEnter Choice : ");

    }

    private void depositMoney() {

        System.out.print("Account Number : ");
        int account = scanner.nextInt();

        System.out.print("Amount : ");
        double amount = scanner.nextDouble();

        bankService.deposit(account, amount);

    }

    private void withdrawMoney() {

        System.out.print("Account Number : ");
        int account = scanner.nextInt();

        System.out.print("Amount : ");
        double amount = scanner.nextDouble();

        bankService.withdraw(account, amount);

    }

    private void transferMoney() {

        System.out.print("Sender Account : ");
        int sender = scanner.nextInt();

        System.out.print("Receiver Account : ");
        int receiver = scanner.nextInt();

        System.out.print("Amount : ");
        double amount = scanner.nextDouble();

        bankService.transfer(sender, receiver, amount);

    }

    private void showTransactions() {

        System.out.print("Account Number : ");

        int accountNumber = scanner.nextInt();

        Account account = bankService.findAccount(accountNumber);

        if (account != null) {

            account.displayBalance();

            account.displayTransactions();

        } else {

            System.out.println("Account not found.");

        }

    }

}