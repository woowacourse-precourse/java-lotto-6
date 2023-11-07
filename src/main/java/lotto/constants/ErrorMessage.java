package lotto.constants;

public enum ErrorMessage implements Message {

    CANNOT_READ_EMPTY_INPUT("빈 값을 입력해선 안됩니다."),
    INVALID_NUMBER_FORMAT("올바른 형태가 아닙니다."),
    ;

    private static final String PREFIX = "[ERROR] ";

    private static final String SUFFIX = " 다시 입력해 주세요.";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return PREFIX + this.message + SUFFIX;
    }
}
