package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;

import model.Customer;
import java.util.Collection;

public class FileManager {
    private static final String ACCOUNT_FILE = "data/accounts.txt";

    private static final String CUSTOMER_FILE = "data/customers.txt";

    // Constructor

    public FileManager() {

        createDataFolder();

    }

    // Create Data Folder
    private void createDataFolder() {

        File folder = new File("data");

        if (!folder.exists()) {

            folder.mkdir();

        }

    }

    public void saveAccounts(Collection<Account> accounts) {

        try (

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter(ACCOUNT_FILE))

        ) {

            for (Account account : accounts) {

                writer.write(

                        account.getClass().getSimpleName()
                                + ","
                                + account.getAccountNumber()
                                + ","
                                + account.getBalance());

                writer.newLine();

            }

            System.out.println("Accounts saved successfully.");

        }

        catch (IOException e) {

            System.out.println("Error saving accounts.");

            e.printStackTrace();

        }

    }

    // loadAccounts()
    public List<Account> loadAccounts() {

        List<Account> accounts = new ArrayList<>();

        File file = new File(ACCOUNT_FILE);

        if (!file.exists()) {

            return accounts;

        }

        try (

                BufferedReader reader = new BufferedReader(
                        new FileReader(file))

        ) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                String type = data[0];

                int accountNumber = Integer.parseInt(data[1]);

                double balance = Double.parseDouble(data[2]);

                if (type.equals("SavingsAccount")) {

                    accounts.add(

                            new SavingsAccount(
                                    accountNumber,
                                    balance));

                }

                else if (type.equals("CurrentAccount")) {

                    accounts.add(

                            new CurrentAccount(
                                    accountNumber,
                                    balance));

                }

            }

        }

        catch (IOException e) {

            e.printStackTrace();

        }

        return accounts;

    }

    // Save Customers
    public void saveCustomers(Collection<Customer> customers) {

        try (

                BufferedWriter writer = new BufferedWriter(
                        new FileWriter(CUSTOMER_FILE))

        ) {

            for (Customer customer : customers) {

                writer.write(customer.toFileString());

                writer.newLine();

            }

            System.out.println("Customers saved successfully.");

        }

        catch (IOException e) {

            System.out.println("Error saving customers.");

            e.printStackTrace();

        }

    }

    // Load Customers
    public List<Customer> loadCustomers() {

        List<Customer> customers = new ArrayList<>();

        File file = new File(CUSTOMER_FILE);

        if (!file.exists()) {

            return customers;

        }

        try (

                BufferedReader reader = new BufferedReader(
                        new FileReader(file))

        ) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Customer customer = new Customer(

                        Integer.parseInt(data[0]),

                        data[1],

                        Integer.parseInt(data[2]),

                        data[3],

                        data[4],

                        data[5]);

                customers.add(customer);

            }

        }

        catch (IOException e) {

            e.printStackTrace();

        }

        return customers;

    }
}