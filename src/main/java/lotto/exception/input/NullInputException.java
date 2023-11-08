package lotto.exception.input;

public class NullInputException extends IllegalArgumentException {
    private static final String ERROR_MSG = "[ERROR] 값을 입력해야 합니다.";

    public NullInputException() {
        super(ERROR_MSG);
    }
}
