public class InsufficientBalanceException extends RuntimeException {
    private String message;

    InsufficientBalanceException() {
    }

    InsufficientBalanceException(String message) {
        super(message);
    }


}
