package lotto.utils;

public enum ErrorMessage {
    IS_NOT_DIVIDED_INTO("[ERROR] %d으로 나누어 떨어지는 값이어야 합니다."),
    IS_LOWER_THAN_PRICE("[ERROR] 구입 금액은 %d보다 크거나 같아야 합니다"),
    IS_PAYMENT_DIGIT("[ERROR] 구입 금액으로는 숫자만 입력 가능합니다."),
    IS_INVALID_LOTTO_SIZE("[ERROR] 로또 사이즈가 유효하지 않습니다."),
    IS_INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또의 숫자 범위가 유효하지 않습니다."),
    IS_LOTTO_NUMBER_DIGIT("[ERROR] 로또 값으로는 숫자만 입력 가능합니다."),
    IS_LOTTO_DUPLICATED("[ERROR] 로또 값은 중복될 수 없습니다."),
    IS_BONUS_NUMBER_DUPLICATED("[ERROR] 보너스 숫자는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
