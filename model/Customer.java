package model;

public class Customer extends Person {

    private int customerId;

    public Customer(int customerId, String name, int age, String phone) {

        super(name, age, phone);

        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void displayCustomer() {

        System.out.println("Customer ID : " + customerId);

        displayPerson();
    }
}