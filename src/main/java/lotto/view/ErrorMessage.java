package lotto.view;

public enum ErrorMessage {
    ILLEGAL_MONEY("구입 금액은 1,000 이상의 1,000 으로 나누어 떨어지는 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
