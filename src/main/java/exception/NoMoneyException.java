package exception;

public class NoMoneyException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 0원으로는 아무것도 살 수 없습니다!";

    public NoMoneyException() {
        super(ERROR_MESSAGE);
    }
}
