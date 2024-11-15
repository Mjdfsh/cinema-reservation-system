
package project_cinema;


public class Snack {
    private String name;
    private String type;
    private double price;

    public Snack(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Snack() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-15s$%s",name , type, price );
    }
    
    
}
