package lotto.exception;

import static lotto.Constants.Constants.LOTTO_NUMBER_COUNT;
import static lotto.Constants.Constants.LOTTO_PRICE;
import static lotto.Constants.Constants.MAX_RANDOM_NUMBER;
import static lotto.Constants.Constants.MIN_RANDOM_NUMBER;

public enum ErrorCode {
    NOT_INTEGER_INPUT("숫자만 입력이 가능합니다."),
    BLANK_INPUT("빈 값은 입력이 불가능 합니다."),

    PURCHASE_AMOUNT_NOT_PRICE_UNIT(String.format("로또 가격인 %d원 단위로만 구매가 가능합니다.", LOTTO_PRICE)),
    PURCHASE_AMOUNT_NOT_POSITIVE("양수만 입력이 가능합니다."),

    LOTTO_NUMBER_DUPLICATE("로또 숫자들은 중복이 불가능합니다."),
    LOTTO_NUMBER_RANGE(
        String.format("로또 숫자들은 %d와 %d 숫자로 구성되어야 합니다.", MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)),
    LOTTO_NUMBER_SIZE(String.format("로또는 %d개의 숫자로 구성되어야 합니다.", LOTTO_NUMBER_COUNT)),

    BONUS_NUMBER_RANGE(
        String.format("보너스 번호는 %d와 %d 숫자만 가능합니다.", MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)),
    BONUS_NUMBER_DUPLICATE("당첨번호와 보너스 번호는 중복이 불가능합니다.");

    private final String message;

    ErrorCode(final String errorMessage) {
        message = errorMessage;
    }

    public String getMessage() {
        final String prefix = "[ERROR] ";
        return prefix + message;
    }

}