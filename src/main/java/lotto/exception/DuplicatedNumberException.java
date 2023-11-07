package lotto.exception;

public class DuplicatedNumberException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 중복된 숫자가 있습니다.";

    public DuplicatedNumberException() {
        super(ERROR_MESSAGE);
    }
}
