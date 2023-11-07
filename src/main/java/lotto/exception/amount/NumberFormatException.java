package lotto.exception.amount;

public class NumberFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 금액은 숫자만 입력할 수 있습니다.";

    public NumberFormatException() {
        super(ERROR_MESSAGE);
    }
}
