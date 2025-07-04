package ecommerce.Model.Product;

import java.time.LocalDate;

public final class Biscuits extends Product implements Expirable{
    private LocalDate expiryDate;

    public Biscuits(double price, int quantity, String name, LocalDate expiryDate) {
        super(price, quantity, name);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
}
