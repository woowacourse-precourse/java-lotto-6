package lotto.exception.input;

public class NotIntegerException extends IllegalArgumentException{
    private static final String ERROR_MSG = "[ERROR] 정수를 입력해야 합니다.";

    public NotIntegerException() {
        super(ERROR_MSG);
    }
}
