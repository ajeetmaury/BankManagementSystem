package model;

public class Customer extends Person {

    private int customerId;

    private String username;
    private String password;

    public Customer(
            int customerId,
            String name,
            int age,
            String phone,
            String username,
            String password) {

        super(name, age, phone);

        this.customerId = customerId;
        this.username = username;
        this.password = password;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void displayCustomer() {

        System.out.println("Customer ID : " + customerId);
        displayPerson();
    }

    public String toFileString() {

        return customerId
                + ","
                + getName()
                + ","
                + getAge()
                + ","
                + getPhone()
                + ","
                + username
                + ","
                + password;

    }
}