package lotto.exception;

public class NotMultipleOf1000Exception extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 구입한 금액은 1000으로 나누어떨어져야하고 0이 아니여야 합니다.";

    public NotMultipleOf1000Exception() {
        super(ERROR_MESSAGE);
    }

}
