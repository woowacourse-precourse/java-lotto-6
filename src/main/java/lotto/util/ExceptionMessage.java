package lotto.util;

import static lotto.util.AmountOfLotto.LOTTO_PRICE;
import static lotto.util.AmountOfLotto.MAXIMUM_PRICE;
import static lotto.util.AmountOfLotto.MINIMUM_PRICE;
import static lotto.util.LottoDetails.COUNT_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MAXIMUM_OF_LOTTO_NUMBER;
import static lotto.util.LottoDetails.MINIMUM_OF_LOTTO_NUMBER;

public enum ExceptionMessage {
    INVALID_INPUT_TYPE("숫자 형식으로 입력해주세요."),
    NOT_POSITIVE_INPUT(MINIMUM_PRICE.getPrice() + "원 이상의 로또 구입 금액을 입력해주세요."),
    BIGGER_THAN_MAX(MAXIMUM_PRICE.getPrice() + "원 이하의 로또 구입 금액을 입력해주세요."),
    NOT_DIVIDE_BY_LOTTO_PRICE(LOTTO_PRICE.getPrice() + "원 단위의 금액을 입력해주세요."),

    INVALID_TYPE("올바른 형식의 숫자를 입력해주세요."),

    BLANK_LOTTO_NUMBER("공백이 아닌 문자를 입력해주세요."),
    INVALID_NUMBER_OF_LOTTO_NUMBER(COUNT_OF_LOTTO_NUMBER.getDetails() + "개의 번호를 입력해주세요."),
    SMALLER_THAN_MIN_LOTTO_NUMBER(MINIMUM_OF_LOTTO_NUMBER.getDetails() + " 이상의 번호를 입력해주세요."),
    BIGGER_THAN_MAX_LOTTO_NUMBER(MAXIMUM_OF_LOTTO_NUMBER.getDetails() + " 이하의 번호를 입력해주세요"),
    DUPLICATE_LOTTO_NUMBER("중복되지 않은 숫자를 입력해주세요."),

    INVALID_PRIZE_MONEY("당첨 금액이 올바르지 않습니다."),
    INVALID_AMOUNT_OF_INVESTMENT("투자 금액이 올바르지 않습니다."),
    INVALID_RATE_OF_RESULT("수익률이 올바르지 않습니다.");

    private final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
