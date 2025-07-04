package ecommerce.Exception;

public final class OutOfStockException extends RuntimeException {
    public OutOfStockException() {
        super("Requested quantity exceeds available product stock.");
    }
}
