package exception;

public class NumberDuplicateException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 중복된 숫자는 선택될 수 없습니다!";

    public NumberDuplicateException() {
        super(ERROR_MESSAGE);
    }
}
