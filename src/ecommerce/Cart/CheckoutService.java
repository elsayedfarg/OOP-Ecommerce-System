package ecommerce.Cart;

import ecommerce.Exception.EmptyCartException;
import ecommerce.Exception.InsufficientBalanceException;
import ecommerce.Exception.OutOfStockException;
import ecommerce.Exception.ProductExpiredException;
import ecommerce.Model.Customer;
import ecommerce.Model.Product.Expirable;
import ecommerce.Model.Product.Product;
import ecommerce.Model.Product.Shippable;
import ecommerce.Shipping.ShippableItem;
import ecommerce.Shipping.ShippingService;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new EmptyCartException();
        }

        double subtotal = 0;
        double shippingFee = 0;
        List<ShippableItem> toShip = new ArrayList<>();

        for (CartItem item : cart.getCartItems()) {
            Product product = item.getProduct();
            int qty = item.getQuantity();

            // Stock check
            if (qty > product.getQuantity()) {
                throw new OutOfStockException();
            }

            // Expiry check
            if (product instanceof Expirable) {
                if (((Expirable) product).isExpired()) {
                    throw new ProductExpiredException();
                }
            }

            // Subtotal
            double lineTotal = product.getPrice() * qty;
            subtotal += lineTotal;

            // Shipping
            if (product instanceof Shippable) {
                double weight = ((Shippable) product).getWeight() * qty;
                shippingFee += calculateShipping(weight);

                // Add formatted ShippableItem
                String label = qty + "x " + product.getName();
                toShip.add(new ShippableItem() {
                    @Override
                    public String getName() {
                        return label;
                    }

                    @Override
                    public double getWeight() {
                        return weight;
                    }
                });
            }
        }

        double total = subtotal + shippingFee;

        // Balance check
        if (customer.getBalance() < total) {
            throw new InsufficientBalanceException();
        }

        // Deduct balance
        customer.deductBalance(total);

        // Call shipping
        if (!toShip.isEmpty()) {
            new ShippingService().shipItems(toShip);
        }

        // Print receipt
        System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart.getCartItems()) {
            String line = String.format("%dx %s %.0f",
                    item.getQuantity(),
                    item.getProduct().getName(),
                    item.getProduct().getPrice() * item.getQuantity()
            );
            System.out.println(line);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f%n", subtotal);
        System.out.printf("Shipping %.0f%n", shippingFee);
        System.out.printf("Amount %.0f%n", total);
    }

    private double calculateShipping(double weight) {
        return weight * 10; // $10 per kg
    }
}
