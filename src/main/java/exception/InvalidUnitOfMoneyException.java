package exception;

public class InvalidUnitOfMoneyException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 1,000원 단위로 값이 입력되어야 합니다!";

    public InvalidUnitOfMoneyException() {
        super(ERROR_MESSAGE);
    }
}
