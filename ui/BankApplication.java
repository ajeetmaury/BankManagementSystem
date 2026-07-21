package ui;

import java.util.Scanner;
import model.Account;
import model.CurrentAccount;
import model.Customer;
import model.SavingsAccount;
import service.BankService;
import service.LoginService;

public class BankApplication {

    // Fields
    private Scanner scanner;

    private BankService bankService;

    private LoginService loginService;

    // Constructor
    public BankApplication() {

        scanner = new Scanner(System.in);

        bankService = new BankService();

        loginService = new LoginService();

        initializeAccounts();

        initializeCustomers();

    }

    // start()
    public void start() {

        boolean running = true;

        while (running) {

            showLoginMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    adminLogin();

                    break;

                case 2:

                    customerLogin();

                    break;

                case 3:

                    running = false;

                    System.out.println("\nThank You!");

                    break;

                default:

                    System.out.println("\nInvalid Choice.");

            }

        }

        scanner.close();

    }

    // Login Menu
    private void showLoginMenu() {

        System.out.println();

        System.out.println("===================================");

        System.out.println("   BANK MANAGEMENT SYSTEM");

        System.out.println("===================================");

        System.out.println("1. Admin Login");

        System.out.println("2. Customer Login");

        System.out.println("3. Exit");

        System.out.print("\nEnter Choice : ");

    }

    // Admin Menu
    private void adminLogin() {

        System.out.print("Username : ");

        String username = scanner.nextLine();

        System.out.print("Password : ");

        String password = scanner.nextLine();

        if (loginService.adminLogin(username, password)) {

            System.out.println("\nLogin Successful!");

            runAdminMenu();

        } else {

            System.out.println("\nInvalid Username or Password.");

        }

    }

    // Customer Menu
    private void customerLogin() {

        System.out.print("Username : ");

        String username = scanner.nextLine();

        System.out.print("Password : ");

        String password = scanner.nextLine();

        Customer customer = loginService.customerLogin(
                username,
                password);

        if (customer != null) {

            System.out.println();

            System.out.println(
                    "Welcome "
                            +
                            customer.getName());

        } else {

            System.out.println("\nInvalid Username or Password.");

        }

    }

    // Admin Menu Methods
    private void runAdminMenu() {

        boolean running = true;

        while (running) {

            displayAdminMenu();

            // int choice = scanner.nextInt();
            int choice = scanner.nextInt();
            scanner.nextLine();

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

                    System.out.println("\nLogging Out...");

                    break;

                default:

                    System.out.println("\nInvalid Choice.");

            }

        }

    }

    // ==============================
    // Banking Operations
    private void displayAdminMenu() {

        System.out.println();

        System.out.println("==============================");

        System.out.println(" ADMIN MENU");

        System.out.println("==============================");

        System.out.println("1. Show All Accounts");

        System.out.println("2. Deposit");

        System.out.println("3. Withdraw");

        System.out.println("4. Transfer");

        System.out.println("5. Transaction History");

        System.out.println("6. Logout");

        System.out.print("\nEnter Choice : ");

    }

    // ============================
    // Initialization Methods
    private void initializeAccounts() {

        bankService.addAccount(
                new SavingsAccount(
                        101,
                        10000));

        bankService.addAccount(
                new CurrentAccount(
                        102,
                        25000));

        bankService.addAccount(
                new SavingsAccount(
                        103,
                        5000));

    }

    private void initializeCustomers() {

        loginService.addCustomer(

                new Customer(

                        1,

                        "Ajeet Kumar",

                        20,

                        "9876543210",

                        "ajeet",

                        "1234"));

    }

    // Deposit
    private void depositMoney() {

        System.out.print("\nEnter Account Number : ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter Deposit Amount : ");
        double amount = scanner.nextDouble();

        bankService.deposit(accountNumber, amount);

    }

    // Withdraw
    private void withdrawMoney() {

        System.out.print("\nEnter Account Number : ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter Withdrawal Amount : ");
        double amount = scanner.nextDouble();

        bankService.withdraw(accountNumber, amount);

    }

    // Transfer
    private void transferMoney() {

        System.out.print("\nEnter Sender Account Number : ");
        int senderAccount = scanner.nextInt();

        System.out.print("Enter Receiver Account Number : ");
        int receiverAccount = scanner.nextInt();

        System.out.print("Enter Transfer Amount : ");
        double amount = scanner.nextDouble();

        bankService.transfer(
                senderAccount,
                receiverAccount,
                amount);

    }

    // Transaction History
    private void showTransactions() {

        System.out.print("\nEnter Account Number : ");

        int accountNumber = scanner.nextInt();

        Account account = bankService.findAccount(accountNumber);

        if (account != null) {

            System.out.println();

            account.displayBalance();

            account.displayTransactions();

        } else {

            System.out.println("\nAccount not found.");

        }

    }

    // Helper Methods

}