package lotto.exception.errorcode;

import static lotto.exception.errorcode.ErrorCodeConstant.ERROR_MESSAGE_PREFIX;

public enum InputErrorCode {

    INVALID_LOTTO_NUMBER_RANGE(ERROR_MESSAGE_PREFIX + "로또 번호의 범위는 1 ~ 45 사이여야 합니다."),
    INVALID_LOTTO_NUMBER_SIZE(ERROR_MESSAGE_PREFIX + "로또 번호는 총 6개여야 합니다."),
    INVALID_LOTTO_PURCHASE_PRICE(ERROR_MESSAGE_PREFIX + "로또 구매 금액은 1,000원 단위여야 합니다."),
    DUPLICATED_LOTTO_NUMBER(ERROR_MESSAGE_PREFIX + "로또 번호는 중복이 아니여야 합니다.");

    private final String message;

    InputErrorCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
