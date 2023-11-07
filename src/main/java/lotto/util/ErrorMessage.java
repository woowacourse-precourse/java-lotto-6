package lotto.util;

public enum ErrorMessage {
    PURCHASE_AMOUNT("1000원 단위의 숫자만 입력해 주세요."),
    ZERO_NUMBER("0보다 큰 숫자를 입력해 주세요."),
    NOT_NUMBER("숫자를 입력해 주세요.");

    private static final String ERROR_FORMAT = "[ERROR] %s";
    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return String.format(ERROR_FORMAT, errorMessage);
    }
}
