package exception;

public class WrongMoneyUnitException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE_START = "[ERROR] ";
    private static final String ERROR_MESSAGE = ERROR_MESSAGE_START + "로또 구입 금액은 1000원 단위로 입력해야 합니다.";

    public WrongMoneyUnitException() {
        super(ERROR_MESSAGE);
    }
}
