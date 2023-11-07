package lotto.exception;

public class InvalidPurchaseAmountException extends RuntimeException {
    private static final String MESSAGE = "[ERROR] 구입 금액은 1000원 이상이어야 합니다.";

    public InvalidPurchaseAmountException() {
        super(MESSAGE);
    }
}
