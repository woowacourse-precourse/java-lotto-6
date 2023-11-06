package lotto.util;

import static lotto.util.AmountOfLotto.LOTTO_PRICE;
import static lotto.util.AmountOfLotto.MAXIMUM_PRICE;
import static lotto.util.AmountOfLotto.MINIMUM_PRICE;

public enum ExceptionMessage {
    INVALID_INPUT_TYPE("숫자 형식으로 입력해주세요."),
    NOT_POSITIVE_INPUT(MINIMUM_PRICE.getPrice() + "원 이상의 로또 구입 금액을 입력해주세요."),
    BIGGER_THAN_MAX(MAXIMUM_PRICE.getPrice() + "원 이하의 로또 구입 금액을 입력해주세요."),
    NOT_DIVIDE_BY_LOTTO_PRICE(LOTTO_PRICE.getPrice() + "원 단위의 금액을 입력해주세요."),

    INVALID_LONG_TYPE("올바른 형식의 숫자를 입력해주세요.");

    private final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
