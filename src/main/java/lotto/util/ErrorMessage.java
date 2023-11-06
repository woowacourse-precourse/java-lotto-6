package lotto.util;

public enum ErrorMessage {
    NOT_NUMERIC_INPUT_ERROR("숫자만 입력 가능합니다. "),
    EMPTY_INPUT_ERROR("비어있는 입력은 불가능합니다. "),
    INVALID_INPUT_PURCHASE_MONEY("유효한 로또 구입 금액이 아닙니다. ");

    private final String message;
    private final String baseMessage = "[ERROR]";

    ErrorMessage(String message) {
        this.message = baseMessage + message;
    }

    public String getMessage() {
        return message;
    }
}
