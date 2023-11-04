package lotto.exception;

import static lotto.domain.constants.LottoConstraint.*;

public enum ErrorMessage {
    /**
     * Client issue
     */
    PAYMENT_NOT_INTEGER("구입 비용은 정수가 입력되어야 합니다."),

    NOT_ENOUGH_PAYMENT(
            String.format(
                    "구입 비용은 %d원 이상으로 입력되어야 합니다.",
                    UNIT_PRICE.getValue())
    ),
    NUMBER_OUT_OF_RANGE(
            String.format(
                    "로또 번호는 %d에서 %d사이의 숫자여야 합니다.",
                    NUMBER_LOWER_BOUND.getValue(),
                    NUMBER_UPPER_BOUND.getValue())
    ),
    PAYMENT_NOT_DIVISIBLE_BY_UNIT_PRICE(
            String.format(
                    "구입 비용은 %d원 단위로 입력되어야 합니다.",
                    UNIT_PRICE.getValue())
    ),


    /**
     * System Issue
     */
    NUMBER_COUNT_INVALID("뽑은 로또의 갯수가 시스템 설정과 다릅니다."),
    NUMBER_DUPLICATED("뽑은 로또 중 중복된 숫자가 있습니다.");


    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
