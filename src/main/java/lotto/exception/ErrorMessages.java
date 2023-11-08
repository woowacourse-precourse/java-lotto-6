package lotto.exception;

public enum ErrorMessages {
    INPUT_INVALID_NUMBER("[ERROR] 구입 금액은 숫자로만 이루어져야 합니다."),
    INPUT_INVALID_MIN_AMOUNT("[ERROR]구입 금액은 1,000원 단위이어야 합니다."),
    DUPLICATE_NUMBER("[ERROR]중복된 숫자가 포함되어 있습니다."),
    INVALID_DIVISIBLE("[ERROR]입력 단위가 1,000원으로 나누어 떨어지지 않습니다."),
    INVALID_RANGE("[ERROR]입력값이 1~45가 아닙니다."),
    INVALID_WINNING_NUMBER_COUNT("[ERROR]입력한 숫자가 6개가 아닙니다."),
    ;
    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
