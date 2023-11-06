package lotto.constant;

public enum ErrorMessage {
    NON_INTEGER_ERROR("정수가 아닙니다."),
    INVALID_PURCHASE_AMOUNT("유효하지 않은 구입금액입니다.");

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(ERROR_MESSAGE_FORMAT, message);
    }
}
