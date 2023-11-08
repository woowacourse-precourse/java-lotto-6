package lotto.exception;

public class DuplicateNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";
    public DuplicateNumberException() {
        super(ERROR_MESSAGE);
    }
}
