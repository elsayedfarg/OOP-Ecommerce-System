package ecommerce.Exception;

public final class ProductExpiredException extends RuntimeException{
    public ProductExpiredException() {
        super("One or more products in the cart have expired.");
    }
}
