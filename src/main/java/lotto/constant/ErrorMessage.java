package lotto.constant;

public enum ErrorMessage {
    NON_INTEGER_ERROR("정수가 아닙니다."),
    NON_POSITIVE_PURCHASE_AMOUNT("구입금액은 양수여야 합니다."),
    CAN_NOT_DIVIDE_LOTTO_PRICE_PURCHASE_AMOUNT("구입금액은 로또가격으로 나누어 떨어져야 합니다."),
    COMMA_SEPARATED_INTEGERS("콤마로 구분되는 정수여야 합니다.");

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(ERROR_MESSAGE_FORMAT, message);
    }
}
