package lotto.exception;

public enum InputErrorCode {

    NOT_POSITIVE_INTEGER_INPUT("양수만 입력이 가능합니다."),
    NOT_INTEGER_INPUT("숫자만 입력이 가능합니다."),
    BLANK_INPUT("빈 값은 입력이 불가능 합니다.");

    private final String message;

    InputErrorCode(final String errorMessage) {
        message = errorMessage;
    }

    public String getMessage() {
        final String prefix = "[ERROR] ";
        return prefix + message;
    }

}