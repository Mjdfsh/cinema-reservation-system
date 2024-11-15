
package project_cinema;


public class Customer {
    private String name;
    private int phoneNumber;
    private int age;

    public Customer() {
    }

    public Customer(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", phoneNumber=" + phoneNumber + '}';
    }
    
}
