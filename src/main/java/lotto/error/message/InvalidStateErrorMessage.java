package lotto.error.message;

import static lotto.global.Constant.LOTTO_MAX_NUMBER;
import static lotto.global.Constant.LOTTO_MIN_NUMBER;
import static lotto.global.Constant.LOTTO_NUMBERS_COUNT;
import static lotto.global.Constant.LOTTO_PRICE;

import lotto.lotto.LottoResult;

public enum InvalidStateErrorMessage implements ErrorMessage {
    LOTTO_NUMBERS_COUNT_NOT_MATCH(String.format("로또 번호는 %d개여야 합니다.", LOTTO_NUMBERS_COUNT.getNumber())),
    LOTTO_NUMBERS_DUPLICATE(String.format("%d개의 로또 번호는 중복될 수 없습니다.", LOTTO_NUMBERS_COUNT.getNumber())),
    LOTTO_NUMBERS_OUT_OF_RANGE(
            String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", LOTTO_MIN_NUMBER.getNumber(), LOTTO_MAX_NUMBER.getNumber())),
    PURCHASE_AMOUNT_UNDER_LOTTO_PRICE(String.format("구입 금액은 %d원 이상이어야 합니다.", LOTTO_PRICE.getNumber())),
    PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE(String.format("구입 금액은 %d의 배수만 가능합니다.", LOTTO_PRICE.getNumber())),
    LOTTO_RESULT_STATE_ERROR(String.format("%s가 잘못 설정되었습니다.", LottoResult.class.getName())),
    UNKNOWN_ERROR_MESSAGE("알 수 없는 오류가 발생했습니다.");

    private final String message;

    InvalidStateErrorMessage(String message) {
        this.message = messageHeader + message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
