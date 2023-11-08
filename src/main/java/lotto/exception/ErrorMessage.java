package lotto.exception;

public enum ErrorMessage {
    NOT_A_NUMBER_TO_CONVERT("숫자를 입력해야 합니다."),
    NO_WITHIN_SCOPE_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("중복되는 로또 번호가 존재합니다."),
    NOT_BUY_AMOUNT_1000_WON_UNIT("구입 금액이 1000원으로 나누어 떨어지지 않습니다."),
    NOT_POSITIVE_NUMBER("구입 금액이 0보다 커야합니다."),
    INVALID_LOTTO_NUMBER_LENGTH("로또 번호 개수가 6개여야 합니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
