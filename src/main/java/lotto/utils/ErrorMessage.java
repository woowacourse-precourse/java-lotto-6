package lotto.utils;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] "),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 %d~%d사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
    public String getFormattedMessage(int minNumber, int maxNumber) {
        return ERROR_PREFIX + String.format(message, minNumber, maxNumber);
    }
}
