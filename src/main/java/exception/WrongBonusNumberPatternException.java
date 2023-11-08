package exception;

public class WrongBonusNumberPatternException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE_START = "[ERROR] ";
    private static final String ERROR_MESSAGE = ERROR_MESSAGE_START + "보너스 번호는 숫자여야 합니다.";

    public WrongBonusNumberPatternException() {
        super(ERROR_MESSAGE);
    }
}
