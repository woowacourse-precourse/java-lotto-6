package exception;

public class WrongMoneyInputException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE_START = "[ERROR] ";
    private static final String ERROR_MESSAGE = ERROR_MESSAGE_START + "로또 구입 금액은 숫자만 입력 가능합니다.";

    public WrongMoneyInputException() {
        super(ERROR_MESSAGE);
    }

}
