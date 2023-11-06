package lotto.constant;

public enum ErrorMessage {
    NOT_NUMBER("입력값은 숫자여야 합니다."),
    NOT_INITIALIZED("도메인 객체가 초기화되지 않았습니다."),
    INVALID_WINNING_NUMBERS("잘못된 당첨 번호 형식입니다."),
    INVALID_NUMBER_RANGE(
            String.format(
                    "로또 번호는 %d부터 %d 사이의 숫자여야 합니다.",
                    LottoRule.MIN_NUMBER.toValue(), LottoRule.MAX_NUMBER.toValue())),
    INVALID_PURCHASE_AMOUNT("구매 금액이 잘못되었습니다."),
    NOT_POSITIVE_PROFIT("수익이 음수가 될 수 없습니다."),
    DUPLICATE_LOTTO_NUMBER("로또는 중복 숫자가 포함되어 발행될 수 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String toValue() {
        return this.message;
    }
}
