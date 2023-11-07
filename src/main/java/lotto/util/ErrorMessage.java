package lotto.util;

public enum ErrorMessage {
    PURCHASE_AMOUNT("%d원 단위의 숫자만 입력해 주세요."),
    ZERO_NUMBER("0보다 큰 숫자를 입력해 주세요."),
    NOT_NUMBER("숫자를 입력해 주세요."),
    LOTTO_SIZE("%d개의 숫자를 입력해 주세요."),
    DUPLICATE("중복 없이 숫자를 입력해 주세요."),
    NUMBER_RANGE("%d에서 %d 사이의 숫자를 입력해 주세요.");

    private static final String ERROR_FORMAT = "[ERROR] %s";
    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return String.format(ERROR_FORMAT, errorMessage);
    }

    public String getMessage(int number) {
        String errorMessage = String.format(this.errorMessage, number);
        return String.format(ERROR_FORMAT, errorMessage);
    }

    public String getMessage(int startNumber, int endNumber) {
        String errorMessage = String.format(this.errorMessage, startNumber, endNumber);
        return String.format(ERROR_FORMAT, errorMessage);
    }
}
