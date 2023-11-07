package lotto.exception.amount;

public class IllegalCipherException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 금액은 1,000원 단위로 입력해야 합니다.";

    public IllegalCipherException() {
        super(ERROR_MESSAGE);
    }
}
