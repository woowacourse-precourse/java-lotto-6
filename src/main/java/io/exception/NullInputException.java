package io.exception;

/**
 * 입력이 Null일 경우 예외
 */
public final class NullInputException extends IllegalArgumentException {
    public static final String NULL_INPUT_EXCEPTION_MESSAGE = "입력은 null이 될 수 없습니다.";

    public NullInputException() {
        super(NULL_INPUT_EXCEPTION_MESSAGE);
    }
}
