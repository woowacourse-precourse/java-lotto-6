package lotto.utils;

public enum InputException {
    NOT_DIGIT_FORM("입력은 숫자의 형식이어야 합니다.");

    private static final String ERROR_SYMBOL = "[ERROR] ";
    private final String message;

    InputException(String message) {
        this.message = ERROR_SYMBOL + message;
    }

    public void throwException() {
        throw new IllegalArgumentException(message);
    }

    public String getMessage() {
        return message;
    }
}
