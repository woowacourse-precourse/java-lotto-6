package lotto.controller.exception;

public final class InvalidInputFormatException extends IllegalArgumentException {
    private static final String INVALID_INPUT_FORMAT_EXCEPTION = "유효하지 않은 형식입니다.\n1,2,3,4,5,6 형태로 입력해주세요.";

    public InvalidInputFormatException() {
        super(INVALID_INPUT_FORMAT_EXCEPTION);
    }
}
