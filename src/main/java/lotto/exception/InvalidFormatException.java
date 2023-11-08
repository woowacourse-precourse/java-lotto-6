package lotto.exception;

public class InvalidFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 형식에 맞지 않는 입력값입니다.";

    public InvalidFormatException() {
        super(ERROR_MESSAGE);
    }
}
