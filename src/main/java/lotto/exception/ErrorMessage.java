package lotto.exception;

public enum ErrorMessage {
    INVALID_PURCHASE_AMOUNT("구매 단위는 1,000원 단위여야 합니다.");
    private final String message;
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE_PREFIX + message;
    }
}
