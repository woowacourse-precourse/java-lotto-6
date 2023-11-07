package lotto.domain.exception;

public enum InputException {
    INVALID_EMPTY_INPUT("빈 값은 입력할 수 없습니다."),
    INVALID_NUMERIC_INPUT("입력값은 숫자만 입력 할 수 있습니다."),
    INVALID_NUMBER_RANGE("입력값은 숫자 내에서만 가능합니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    InputException(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }

}
