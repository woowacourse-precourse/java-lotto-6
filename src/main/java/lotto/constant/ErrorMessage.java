package lotto.constant;

public enum ErrorMessage {
    PURCHASE_AMOUNT_IS_EMPTY("공백은 입력될 수 없습니다."),
    PURCHASE_AMOUNT_IS_NOT_A_NUMBER("구입 금액은 숫자만 입력될 수 있습니다.");

    private static final String ERROR_HEAD = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_HEAD + message;
    }

    public String getMessage() {
        return message;
    }

    public void throwIllegalArgumentException() {
        throw new IllegalArgumentException(message);
    }

    public void throwNumberFormatException() {
        throw new NumberFormatException(message);
    }
}
