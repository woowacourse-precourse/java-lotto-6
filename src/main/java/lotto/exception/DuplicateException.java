package lotto.exception;

public class DuplicateException extends IllegalArgumentException {
    public static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 로또번호가 있습니다";

    public DuplicateException() {
        super(DUPLICATE_ERROR_MESSAGE);
    }
}
