package lotto.exception;

public class InvalidLottoPurchaseException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 1000으로 나누어 떨어지는 숫자여야 합니다.";

    public InvalidLottoPurchaseException() {
        super(ERROR_MESSAGE);
    }
}
