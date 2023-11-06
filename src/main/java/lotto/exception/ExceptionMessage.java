package lotto.exception;

public enum ExceptionMessage {
    PREFIX("[ERROR] "),
    LOTTO_COUNTS_INVALID("로또 숫자의 갯수는 정확히 6개만 가능합니다. 현재 로또 숫자의 갯수 : %s"),
    LOTTO_NUMBER_OUT_OF_RANGE("각 로또 숫자의 범위는 1 이상 45 이하여야 합니다. 현재 입력한 번호 : %s"),
    LOTTO_NUMBERS_DUPLICATED("로또 번호는 중복되지 않아야 합니다. 입력한 로또 번호 : %s"),
    INVALID_LOTTO_INPUT("숫자와 콤마 구분자 이외의 문자는 허용하지 않습니다. 입력한 값 : %s"),
    INVALID_BONUS_INPUT("숫자 이외의 문자는 허용하지 않습니다. 입력한 값 : %s"),
    INVALID_PURCHASE_AMOUNT("구입금액은 숫자만 입력 가능합니다. 입력값 : %s"),
    PURCHASE_AMOUNT_HAS_REMAINDER("구입금액은 1,000원 단위만 가능합니다. 입력값 : %d"),
    BONUS_NUMBER_ALREADY_CONTAINS_IN_WINNING_NUMBERS("당첨 번호와 보너스 번호는 중복될 수 없습니다. 입력한 당첨 번호 : %s, 입력한 보너스 번호 : %s"),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
