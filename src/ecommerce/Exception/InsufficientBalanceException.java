package ecommerce.Exception;

public final class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException() {
        super("Customer does not have enough balance to complete the purchase.");
    }
}
