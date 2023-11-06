package lotto.exception;

public class InvalidMinimumAmountException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 최소 금액은 1,000원 입니다.";

    public InvalidMinimumAmountException() {
        super(ERROR_MESSAGE);
    }
}
