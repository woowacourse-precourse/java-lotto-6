package lotto.exception;

public enum ErrorMessage {
    INVALID_PURCHASE_AMOUNT("구매 단위는 1,000원 단위여야 합니다."),
    DUPLICATE_LOTTO_NUMBERS("하나의 로또에 중복된 숫자가 있습니다."),
    OUT_OF_RANGE_LOTTO_NUMBERS("하나 이상의 로또 내 숫자가 유효한 범위 밖입니다."),
    NOT_NUMERIC_PURCHASE_AMOUNT("입력된 구매 금액이 정수가 아닙니다.");
    private final String message;
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE_PREFIX + message;
    }
}
