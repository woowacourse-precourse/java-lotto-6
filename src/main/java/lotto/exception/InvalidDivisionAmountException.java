package lotto.exception;

public class InvalidDivisionAmountException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 1,000원 단위로 입력해주세요.";

    public InvalidDivisionAmountException() {
        super(ERROR_MESSAGE);
    }
}
