package lotto.exception;

public enum ErrorMessage {
    INVALID_LOTTO_NUMBER_RANGE("로또 숫자는 1~45까지의 정수만 선택해야 합니다."),
    DUPLICATE_LOTTO_NUMBER("로또 숫자는 중복될 수 없습니다."),
    INCORRECT_LOTTO_NUMBERS_COUNT("로또 숫자는 정확히 6개여야 합니다."),
    LOTTO_CREATION_ERROR("로또를 생성할 수 없습니다."),
    INVALID_PURCHASE_AMOUNT_FORMAT("구매 금액은 정수만 입력 가능합니다."),
    INVALID_PURCHASE_AMOUNT_VALUE("구매 금액은 0보다 크고 1,000원으로 나누어 떨어져야 합니다."),
    MISSING_WINNING_NUMBERS("당첨 번호가 입력되지 않았습니다."),
    NON_INTEGER_LOTTO_NUMBER("로또 숫자는 정수만 입력 가능합니다."),
    NON_INTEGER_BONUS_NUMBER("보너스 숫자는 정수만 입력 가능합니다.");

    private static final String MESSAGE_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return MESSAGE_PREFIX + message;
    }
}
