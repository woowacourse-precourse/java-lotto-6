package lotto.constant;

public enum ErrorMessage {
    PURCHASE_AMOUNT_IS_EMPTY("공백은 입력될 수 없습니다.");

    private static final String ERROR_HEAD = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_HEAD + message;
    }

    public String getMessage() {
        return message;
    }

    public void throwException() {
        throw new IllegalArgumentException(message);
    }
}
