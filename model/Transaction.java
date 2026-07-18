package model;

import java.time.LocalDateTime;

public class Transaction {

    private String type;
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(String type, double amount) {

        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();

    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void displayTransaction() {

        System.out.printf(
                "%-12s Rs. %.2f   %s%n",
                type,
                amount,
                dateTime);

    }

}