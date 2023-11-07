package lotto.exception;

public class BlankException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 숫자로 제대로 입력해 주세요.";

    public BlankException() {
        super(ERROR_MESSAGE);
    }
}
