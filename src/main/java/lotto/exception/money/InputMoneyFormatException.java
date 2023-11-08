package lotto.exception.money;

public class InputMoneyFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 1,000원 단위의 금액을 입력 해야 합니다.";

    public InputMoneyFormatException() {
        super(ERROR_MESSAGE);
    }
}
