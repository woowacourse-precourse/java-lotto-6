package exception;

public class WrongInputPatternException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE_START = "[ERROR] ";
    private static final String ERROR_MESSAGE = ERROR_MESSAGE_START + "로또 번호 입력은 숫자와 콤마(,)로 구성되어야 합니다.";

    public WrongInputPatternException() {
        super(ERROR_MESSAGE);
    }
}
