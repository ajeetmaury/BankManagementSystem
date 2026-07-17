package model;

public abstract class Person {

    private String name;
    private int age;
    private String phone;

    public Person(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    // Getter
    public int getAge() {
        return age;
    }

    // Setter
    public void setAge(int age) {
        this.age = age;
    }

    // Getter
    public String getPhone() {
        return phone;
    }

    // Setter
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void displayPerson() {
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Phone : " + phone);
    }
}