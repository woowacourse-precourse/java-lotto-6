package lotto.exception;

public class InvalidPurchaseAmountException extends RuntimeException {
    private static final String MESSAGE = "[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.";

    public InvalidPurchaseAmountException() {
        super(MESSAGE);
    }
}
