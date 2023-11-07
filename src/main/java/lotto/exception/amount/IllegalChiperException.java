package lotto.exception.amount;

public class IllegalChiperException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 금액은 1,000원 단위로 입력해야 합니다.";

    public IllegalChiperException() {
        super(ERROR_MESSAGE);
    }
}
