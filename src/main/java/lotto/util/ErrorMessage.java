package lotto.util;

public enum ErrorMessage {

    NUMERIC_ERROR("숫자만 입력 가능 합니다."),
    NEGATIVE_INT_ERROR("자연수만 입력 가능 합니다."),
    MONEY_UNIT_ERROR("1000원 단위만 입력 가능 합니다.");

    private static final String ERROR_FORMAT = "[ERROR] %s";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(ERROR_FORMAT, message);
    }

}
