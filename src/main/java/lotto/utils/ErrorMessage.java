package lotto.utils;

public enum ErrorMessage {
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 %d~%d사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public String getFormattedMessage(int minNumber, int maxNumber) {
        return String.format(message, minNumber, maxNumber);
    }
}
