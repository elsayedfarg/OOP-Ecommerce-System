package ecommerce.Main;

import ecommerce.Cart.Cart;
import ecommerce.Cart.CheckoutService;
import ecommerce.Model.Customer;
import ecommerce.Model.Product.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create a customer
        Customer customer = new Customer("Alice", 10000.0);

        // Create products
        Cheese cheese = new Cheese(100, 5, "Cheese 400g", LocalDate.now().plusDays(5), 0.4);
        Biscuits biscuits = new Biscuits(150, 5, "Biscuits 700g", LocalDate.now().plusDays(3));
        MobileScratchCard scratchCard = new MobileScratchCard(10, 5, "Scratch Card");

        // Create a cart
        Cart cart = new Cart();

        try {
            // Add products to the cart
            cart.addItem(cheese, 2);
            cart.addItem(biscuits, 1);
            cart.addItem(scratchCard, 1);

            // Perform checkout
            CheckoutService checkoutService = new CheckoutService();
            checkoutService.checkout(customer, cart);

        } catch (RuntimeException e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }
    }
}