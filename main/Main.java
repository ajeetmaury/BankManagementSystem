package main;

import java.util.Scanner;

import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;
import service.BankService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankService bank = new BankService();

        bank.addAccount(new SavingsAccount(101, 10000));
        bank.addAccount(new CurrentAccount(102, 25000));
        bank.addAccount(new SavingsAccount(103, 5000));

        boolean running = true;

        while (running) {

            System.out.println("\n==============================");
            System.out.println(" BANK MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Show All Accounts");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Show Transaction History");
            System.out.println("6. Exit");

            System.out.print("\nEnter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    bank.showAllAccounts();
                    break;

                case 2:
                    System.out.print("Account Number : ");
                    int depositAcc = sc.nextInt();

                    System.out.print("Amount : ");
                    double depositAmount = sc.nextDouble();

                    bank.deposit(depositAcc, depositAmount);
                    break;

                case 3:
                    System.out.print("Account Number : ");
                    int withdrawAcc = sc.nextInt();

                    System.out.print("Amount : ");
                    double withdrawAmount = sc.nextDouble();

                    bank.withdraw(withdrawAcc, withdrawAmount);
                    break;

                case 4:
                    System.out.print("Sender Account : ");
                    int sender = sc.nextInt();

                    System.out.print("Receiver Account : ");
                    int receiver = sc.nextInt();

                    System.out.print("Amount : ");
                    double transferAmount = sc.nextDouble();

                    bank.transfer(sender, receiver, transferAmount);
                    break;

                case 5:
                    System.out.print("Account Number : ");
                    int accountNumber = sc.nextInt();

                    Account account = bank.findAccount(accountNumber);

                    if (account != null) {
                        account.displayBalance();
                        account.displayTransactions();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }
        }

        sc.close();
    }
}