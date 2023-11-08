package lotto.error;

public enum ExceptionCode {

    EXCEED_MAX_TRY("최대 5번까지만 재시도할 수 있습니다."),
    INVALID_NUMBER_FORMAT("숫자를 입력해주세요."),
    NEGATIVE_MONEY_AMOUNT("금액은 음수일 수 없습니다."),
    INVALID_BUY_COUNT_UNIT("구매 금액 단위는 1,000원 입니다."),
    EXCEED_BUY_COUNT("로또는 최대 100,000원만 구매가능합니다."),
    INVALID_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호엔 중복이 없어야 합니다.");

    private final String message;

    ExceptionCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
