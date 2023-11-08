package lotto.exception;

public class ArgumentIsZeroException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 0은 입력할 수 없습니다.";
    public ArgumentIsZeroException() {
        super(ERROR_MESSAGE);
    }
}
