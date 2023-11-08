package lotto.error.message;

import static lotto.global.Constant.LOTTO_MAX_NUMBER;
import static lotto.global.Constant.LOTTO_MIN_NUMBER;
import static lotto.global.Constant.LOTTO_NUMBERS_COUNT;
import static lotto.global.Constant.LOTTO_PRICE;

public enum InvalidInputErrorMessage implements ErrorMessage {
    NOT_A_NUMBER("입력하신 값은 숫자가 아닙니다."),
    PURCHASE_AMOUNT_UNDER_LOTTO_PRICE(String.format("구입 금액은 %d원 이상이어야 합니다.", LOTTO_PRICE.getNumber())),
    PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE(String.format("구입 금액은 %d의 배수만 가능합니다.", LOTTO_PRICE.getNumber())),
    OUT_OF_RANGE(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", LOTTO_MIN_NUMBER.getNumber(), LOTTO_MAX_NUMBER.getNumber())),
    WINNING_NUMBERS_COUNT_NOT_MATCH(String.format("입력하신 당첨 번호는 %d개가 아닙니다.", LOTTO_NUMBERS_COUNT.getNumber())),
    WINNING_NUMBERS_DUPLICATE("입력하신 당첨 번호에 중복이 존재합니다."),
    BONUS_NUMBER_IN_WINNING_NUMBER("입력하신 보너스 번호가 이미 당첨 번호에 존재합니다.");

    private final String message;

    InvalidInputErrorMessage(String message) {
        this.message = messageHeader + message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
