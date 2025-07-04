package ecommerce.Exception;

public final class EmptyCartException extends RuntimeException{
    public EmptyCartException() {
        super("Cart is empty.");
    }
}
