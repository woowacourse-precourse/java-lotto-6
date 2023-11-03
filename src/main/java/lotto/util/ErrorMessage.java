package lotto.util;

public enum ErrorMessage {
    INVALID_NUMBER_FORMAT("숫자만 입력해 주세요"),
    INVALID_PURCHASE_AMOUNT("금액은 1000단위로 입력해 주세요");

    private final String message;

    ErrorMessage(String message) {
        String ERROR_MARK = "[ERROR] ";
        this.message = ERROR_MARK + message;
    }

    public String getMessage() {
        return message;
    }
}
