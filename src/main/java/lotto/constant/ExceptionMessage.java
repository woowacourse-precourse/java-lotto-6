package lotto.constant;

public enum ExceptionMessage {
    ERROR("[ERROR] "),
    INVALID_NUMERIC_INPUT("숫자만 입력해주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String toValue() {
        return ERROR.message + message;
    }
}
