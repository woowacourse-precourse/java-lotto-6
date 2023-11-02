package lotto.constant;

public enum IllegalArgumentExceptionType implements ExceptionType<IllegalArgumentException> {
    PARSE_INT_FAIL("숫자만 입력 가능 합니다."),
    MONEY_REMAINS_EXIST("천원 단위로 입력해 주세요."),
    INSUFFICIENT_MONEY("천원 이하의 금액은 입력할 수 없습니다."),
    MAX_MONEY_EXCEEDED("20억을 초과하는 금액은 입력할 수 없습니다.");

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
