package lotto.error;

public enum ErrorMessage {

    // 로또 구입 금액
    NOT_INTEGER_LOTTO_PURCHASE_AMOUNT("로또 구입 금액은 숫자만으로 이루어져야 합니다."),
    START_ZERO_LOTTO_PURCHASE_AMOUNT("로또 구입 금액은 0으로 시작할 수 없습니다."),
    NOT_DIVIDE_LOTTO_PURCHASE_MINIMUM_AMOUNT("로또 구입 금액은 1000으로 나누어 떨어져야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
