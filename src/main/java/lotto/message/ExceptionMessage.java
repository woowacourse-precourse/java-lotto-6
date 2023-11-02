package lotto.message;

public enum ExceptionMessage {
    ERROR_TAG("[ERROR] "),
    INPUT_NOT_NUMBER_MESSAGE("숫자를 입력해야 합니다."),
    INPUT_UNDER_ZERO_MESSAGE("0보다 큰 숫자를 입력해야 합니다."),
    INPUT_NOT_MULTIPLE_OF_UNIT_MESSAGE("%d의 배수를 입력해야 합니다.");


    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getMessage() {
        return exceptionMessage;
    }

    public void throwException() {
        throw new IllegalArgumentException(ERROR_TAG.getMessage() + exceptionMessage);
    }

    public void throwException(String value) {
        throw new IllegalArgumentException(ERROR_TAG.getMessage() + String.format(exceptionMessage, value));
    }
}

