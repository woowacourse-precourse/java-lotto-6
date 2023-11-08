package lotto.domain.enums;


public enum Message {
    INPUT_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),

    COMMA_SEPARATOR(","),

    BUY_LOTTO_COUNT_MESSAGE("%d개를 구매했습니다."),
    RESULT_MESSAGE("당첨 통계\n---"),
    PERFORMANCE_MESSAGE("총 수익률은 %.1f%%입니다."),

    ERROR_INVALID_PRICE_NOT_DIVISIBLE_BY_1000_MESSAGE("[ERROR] 구입금액은 1000원 단위로 입력해 주세요."),
    ERROR_MISSING_SIX_NUMBERS_MESSAGE("[ERROR] 당첨 번호 6개를 입력해 주세요."),
    ERROR_DUPLICATE_NUMBER_MESSAGE("[ERROR] 중복되지 않은 당첨 번호를 입력해 주세요."),
    INVALID_NUMBER_FORMAT("[ERROR] 숫자만 입력해 주세요."),
    ERROR_INVALID_RANGE_MESSAGE("[ERROR] 로또 번호는 1~45 사이의 숫자로 입력해 주세요."),
    ERROR_DUPLICATE_BONUS_NUMBER("[ERROR] 당첨 번호와 중복되지 않은 보너스 번호를 입력해 주세요.");

    private final String value;

    Message(final String value) {
        this.value = value;
    }

    public IllegalArgumentException createException() {
        return new IllegalArgumentException(value);
    }

    public String getValue() {
        return value;
    }
}
