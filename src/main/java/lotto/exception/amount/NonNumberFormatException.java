package lotto.exception.amount;

public class NonNumberFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 금액은 숫자만 입력할 수 있습니다.";

    public NonNumberFormatException() {
        super(ERROR_MESSAGE);
    }
}
