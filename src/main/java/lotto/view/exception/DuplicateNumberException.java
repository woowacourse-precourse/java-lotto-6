package lotto.view.exception;

public class DuplicateNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 숫자 중복";

    public DuplicateNumberException() {
        super(ERROR_MESSAGE);
    }

}
