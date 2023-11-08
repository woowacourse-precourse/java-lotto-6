package lotto.exception;

public enum ExceptionMessage {
    NO_INTEGER_EXCEPTION("정수를 입력해 주세요"),
    BLANK_EXCEPTION("빈 값은 허용하지 않습니다"),
    LOTTO_SIZE_EXCEPTION("로또 번호는 6개 입니다"),
    LOTTO_NUMBERS_DUPLICATE_EXCEPTION("로또 번호는 중복될 수 없습니다"),
    MONEY_TEN_THOUSAND_UNIT_EXCEPTION("구입 금액은 1000원 단위 입니다"),
    WINNING_NUMBERS_SIZE_EXCEPTION("당첨 번호는 6개만 가능합니다"),
    WINNING_NUMBERS_DUPLICATE_EXCEPTION("당첨번호는 중복될 수 없습니다"),
    BONUS_NUMBER_DUPLICATE_EXCEPTION("당첨 번호에 이미 있는 수 입니다"),
    NUMBERS_RANGE_EXCEPTION("1~45사이의 숫자만 가능합니다");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
