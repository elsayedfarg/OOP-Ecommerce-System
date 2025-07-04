package ecommerce.Cart;

import ecommerce.Exception.OutOfStockException;
import ecommerce.Model.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> cartItems=new ArrayList<>();

    public void addItem(Product product,int quantity)
    {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (quantity > product.getQuantity()) {
            throw new OutOfStockException();
        }
        cartItems.add(new CartItem(product, quantity));
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
}
