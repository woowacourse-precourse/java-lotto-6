package lotto.utils;

public enum ErrorMessage {
    IS_NOT_DIVIDED_INTO("[Error] %d으로 나누어 떨어지는 값이어야 합니다."),
    IS_LOWER_THAN_PRICE("[Error] 구입 금액은 %d보다 크거나 같아야 합니다"),
    IS_INVALID_LOTTO_SIZE("[Error] 로또 사이즈가 유효하지 않습니다."),
    IS_INVALID_LOTTO_NUMBER_RANGE("[Error] 로또의 숫자 범위가 유효하지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
