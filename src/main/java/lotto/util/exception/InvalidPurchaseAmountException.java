package lotto.util.exception;

public class InvalidPurchaseAmountException extends IllegalArgumentException {
    private final static String message = "구입 금액은 로또 가격의 배수여야 합니다. 입력값: ";

    public InvalidPurchaseAmountException() {
        super(message);
    }

    public InvalidPurchaseAmountException(int input) {
        super(message + input);
    }

    public InvalidPurchaseAmountException(String input, Exception e) {
        super(message + input, e);
    }
}
