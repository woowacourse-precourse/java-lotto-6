package lotto.exception;

public class InvalidInputNumFormatException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 숫자로 입력해야합니다.";

    public InvalidInputNumFormatException() {
        super(ERROR_MESSAGE);
    }

}
