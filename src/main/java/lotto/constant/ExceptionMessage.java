package lotto.constant;

public enum ExceptionMessage {

    NON_NUMERIC_INPUT_EXCEPTION("숫자만 입력 가능합니다."),
    NON_THOUSAND_UNIT_AMOUNT_EXCEPTION("1,000원 단위로 입력해 주세요."),
    EXCEED_MAX_PURCHASE_AMOUNT_EXCEPTION("최대 구입 가능 금액은 100,000원입니다."),
    MIN_PURCHASE_AMOUNT_EXCEPTION("로또 구입 금액은 최소 1,000원입니다."),
    NO_COMMA_INPUT_EXCEPTION("쉼표(,)로 구분해 주세요."),
    OUT_OF_RANGE_NUMBER_EXCEPTION("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER_EXCEPTION("로또 번호는 중복될 수 없습니다."),
    WINNING_NUMBERS_COUNT_EXCEPTION("로또 번호는 6개여야 합니다."),
    DUPLICATE_BONUS_NUMBER_EXCEPTION("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    ERROR_TAG("[ERROR] ");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_TAG.message + message;
    }
}
