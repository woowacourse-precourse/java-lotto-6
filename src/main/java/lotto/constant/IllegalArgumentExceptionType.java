package lotto.constant;

public enum IllegalArgumentExceptionType implements ExceptionType<IllegalArgumentException> {
    PARSE_INT_FAIL("숫자만 입력 가능 합니다.");

    private final String message;

    IllegalArgumentExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(MESSAGE_FORMAT, message);
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(getMessage());
    }
}
