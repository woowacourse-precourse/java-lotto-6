package lotto.exception.errorcode;

import static lotto.exception.errorcode.ErrorCodeConstant.ERROR_MESSAGE_PREFIX;

public enum InputErrorCode {
    INVALID_LOTTO_NUMBER_RANGE(ERROR_MESSAGE_PREFIX + "로또 번호의 범위는 1 ~ 45 사이여야 합니다."),
    INVALID_LOTTO_NUMBER_SIZE(ERROR_MESSAGE_PREFIX + "로또 번호는 총 6개여야 합니다."),
    INVALID_LOTTO_PURCHASE_PRICE(ERROR_MESSAGE_PREFIX + "로또 구매 금액은 1,000원 단위여야 합니다."),
    INVALID_LOTTO_PURCHASE_PRICE_RANGE(ERROR_MESSAGE_PREFIX + "로또 구매 금액은 최소 1,000원 이상이여야 합니다."),
    DUPLICATED_LOTTO_NUMBER(ERROR_MESSAGE_PREFIX + "로또 번호는 중복이 아니여야 합니다."),
    INPUT_NOT_NUMERIC(ERROR_MESSAGE_PREFIX + "입력값은 숫자이여야 합니다."),
    INPUT_SPLIT_SIZE(ERROR_MESSAGE_PREFIX + "당첨 번호는 쉼표(,)로 구분되는 6자리 수여야 합니다."),
    INVALID_BONUS_NUMBER_RANGE(ERROR_MESSAGE_PREFIX + "보너스 번호의 범위는 1 ~ 45 사이여야 합니다."),
    MISMATCH_PURCHASE_PRICE_AND_LOTTO_COUNT(ERROR_MESSAGE_PREFIX + "로또 개수와 구매 금액이 일치하지 않습니다.");

    private final String message;

    InputErrorCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
