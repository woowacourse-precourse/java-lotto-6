package lotto.utils;

public enum ErrorMessage {
    IS_NOT_DIVIDED_INTO("[Error] %d으로 나누어 떨어지는 값이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
