package exception;

public class NonPositiveMoneyException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE_START = "[ERROR] ";
    private static final String ERROR_MESSAGE = ERROR_MESSAGE_START + "로또 구입 금액은 0원 보다 커야 합니다.";

    public NonPositiveMoneyException() {
        super(ERROR_MESSAGE);
    }
}
