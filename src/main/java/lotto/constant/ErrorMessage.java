package lotto.constant;

public enum ErrorMessage {
    INVALID_NUMBER_OF_LOTTO_NUMBERS("로또 번호는 6개의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBERS("로또 번호는 중복될 수 없습니다."),
    INVALID_INVESTMENT_AMOUNT("투자금액은 남거나 로또 금액보다 작을 수 없습니다.");

    ErrorMessage(String message) {
        this.message = message;
    }
    private final String message;

    public String getMessage() {
        return message;
    }
}
