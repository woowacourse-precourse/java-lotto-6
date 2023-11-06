package lotto.utils;

public enum ErrorMessage {
    IS_NOT_DIVIDED_INTO("[Error] %d으로 나누어 떨어지는 값이어야 합니다."),
    IS_LOWER_THAN_PRICE("[Error] 구입 금액은 %d보다 크거나 같아야 합니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
