package lotto.message;

public enum ExceptionMessage {
    INPUT_NOT_NUMBER_MESSAGE("숫자를 입력해야 합니다."),
    INPUT_UNDER_ZERO_MESSAGE("0보다 큰 숫자를 입력해야 합니다."),
    INPUT_NOT_MULTIPLE_OF_UNIT_MESSAGE("%d의 배수를 입력해야 합니다.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getMessage() {
        return exceptionMessage;
    }

    public String getMessage(int formatValue) {
        return String.format(exceptionMessage, formatValue);
    }

    public void throwException() {
        throw new IllegalArgumentException(ERROR_TAG + exceptionMessage);
    }

    public void throwException(int value) {
        throw new IllegalArgumentException(ERROR_TAG + String.format(exceptionMessage, value));
    }
}

