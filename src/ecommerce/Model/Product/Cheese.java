package ecommerce.Model.Product;

import java.time.LocalDate;

public final class Cheese extends Product implements Expirable,Shippable{
    // Private Fields
    private LocalDate expiryDate;
    private double weight;

    // Constructor
    public Cheese(double price, int quantity, String name, LocalDate expiryDate, double weight) {
        super(price, quantity, name);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    // Implemented Interfaces Methods
    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
