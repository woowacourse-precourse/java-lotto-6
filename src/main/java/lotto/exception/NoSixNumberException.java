package lotto.exception;

public class NoSixNumberException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 6개의 숫자를 쉼표(,)로 나누어 입력하세요.";

    public NoSixNumberException() {
        super(ERROR_MESSAGE);
    }
}
