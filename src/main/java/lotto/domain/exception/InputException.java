package lotto.domain.exception;

public enum InputException {
    INVALID_INPUT_NUMERIC("입력값은 숫자만 입력 할 수 있습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    InputException(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }

}
