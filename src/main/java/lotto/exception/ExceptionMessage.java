package lotto.exception;

import static lotto.constant.ConstantInteger.LOTTO_MAX_NUMBER;
import static lotto.constant.ConstantInteger.LOTTO_MIN_NUMBER;
import static lotto.constant.ConstantInteger.MAX_PRICE;
import static lotto.constant.ConstantInteger.NUMBER_COUNT;
import static lotto.constant.ConstantInteger.UNIT;
import static lotto.constant.ConstantString.ERROR;

public enum ExceptionMessage {

    NULL_POINTER_EXCEPTION_MESSAGE("NULL 값을 입력할 수 없습니다."),
    NOT_NUMBER_EXCEPTION_MESSAGE("입력은 숫자로만 입력할 수 있습니다."),
    DIFFERENT_FORMAT_EXCEPTION_MESSAGE("구입 금액은 " + UNIT + "원 단위로 나누어 떨어져야 합니다."),
    MAX_PRICE_MESSAGE("현재 최대 구입금액은 " + MAX_PRICE + "원 입니다."),
    UNAVAILABLE_NUMBER_COUNT("당첨 번호는 숫자 " + NUMBER_COUNT + "개를 입력하셔야 합니다."),
    NOT_IN_RANGE_NUMBER_INPUT_MESSAGE("로또 번호는 " + LOTTO_MIN_NUMBER + "부터 " + LOTTO_MAX_NUMBER + " 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER_MESSAGE("입력하신 당첨번호에 중복이 존재합니다."),
    DUPLICATED_BONUS_NUMBER_MESSAGE("보너스 번호가 입력하신 당첨번호에 중복이 존재합니다."),
    ;

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }
}
