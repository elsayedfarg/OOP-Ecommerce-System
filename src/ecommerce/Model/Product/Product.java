package ecommerce.Model.Product;

public abstract class Product {
    // Private Fields
    private String name;
    private double price;
    private int quantity;

    // Constructor

    // no need for parameterless constructor => Product is abstract
    //    public Product(){}

    public Product(double price, int quantity, String name) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    // Getters and Setters
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Class Logical Functions
    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }
}
