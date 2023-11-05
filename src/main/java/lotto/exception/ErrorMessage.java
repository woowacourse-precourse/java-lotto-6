package lotto.exception;

import lotto.domain.lottery.constants.LottoConstraint;
import lotto.domain.parser.constants.InputConstraint;

import static java.lang.String.format;

public enum ErrorMessage {

    EMPTY_REQUEST("정상적으로 입력해주세요"),
    REQUEST_NOT_INTEGER("정수형으로 입력되어야 합니다."),
    CONTAIN_WHITESPACE("공백 없이 입력되어야 합니다."),
    NUMBER_DUPLICATED("중복된 숫자가 입력되었습니다."),
    BONUS_NUMBER_DUPLICATED("당첨 번호에 입력한 숫자가 보너스 번호에 입력되었습니다."),
    SYSTEM_CRASHED("시스템 내부에서 예기치 않은 문제가 발생했습니다."),

    NOT_ENOUGH_PAYMENT(
            format(
                    "구입 비용은 로또 1장 구입 비용(%d원) 이상으로 입력되어야 합니다.",
                    LottoConstraint.UNIT_PRICE.getValue())
    ),
    EXCEED_PAYMENT(
            format(
                    "국민체육진흥법 개정안에 따라, 1인당 발행 회차별 %d원을 초과해 구입할 수 없습니다.",
                    LottoConstraint.MAXIMUM_PURCHASE_PAYMENT.getValue())
    ),
    NUMBER_OUT_OF_RANGE(
            format(
                    "번호는 %d에서 %d사이의 숫자여야 합니다.",
                    LottoConstraint.NUMBER_LOWER_BOUND.getValue(),
                    LottoConstraint.NUMBER_UPPER_BOUND.getValue())
    ),
    PAYMENT_NOT_DIVISIBLE_BY_UNIT_PRICE(
            format(
                    "구입 비용은 %d원 단위로 입력되어야 합니다.",
                    LottoConstraint.UNIT_PRICE.getValue())
    ),
    ENDS_WITH_DELIMITER(
            format(
                    "구분자(%s)로 끝나도록 입력할 수 없습니다.",
                    InputConstraint.DELIMITER.getValue())
    ),
    NUMBER_COUNT_INVALID(
            format(
                    "%d개의 숫자를 입력해야 합니다",
                    LottoConstraint.LOTTO_PICK_COUNT.getValue())
    );

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
