package lotto.exception;

public class NonNumberException extends IllegalArgumentException {
    private static final String ONLY_NUMBER_ALLOWED_MESSAGE = "숫자만 입력해 주세요.";

    public NonNumberException() {
        super(ONLY_NUMBER_ALLOWED_MESSAGE);
    }
}
