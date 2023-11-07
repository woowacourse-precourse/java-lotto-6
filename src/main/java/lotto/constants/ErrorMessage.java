package lotto.constants;

import static lotto.constants.LottoConfiguration.LOTTO_SIZE;
import static lotto.constants.LottoConfiguration.MAX_PRICE;
import static lotto.constants.LottoConfiguration.MAX_RANGE;
import static lotto.constants.LottoConfiguration.MIN_PRICE;
import static lotto.constants.LottoConfiguration.MIN_RANGE;

public enum ErrorMessage {
    // 공통
    ERROR_PREFIX("[ERROR] "),

    // 입력 값 에러
    ERROR_NULL_INPUT("NULL 값이 입력 되었습니다."),
    ERROR_BLANK_INPUT("공백,빈 값이 입력 되었습니다."),
    ERROR_NON_NUMBER_TYPE_INPUT("숫자 타입의 값이 입력되지 않았습니다."),

    // 로또 번호 에러
    ERROR_LOTTO_NUMBER_SIZE("로또 번호가 " + LOTTO_SIZE.getConfig() + "자리가 아닙니다."),
    ERROR_LOTTO_NUMBER_DUPLICATE("중복된 로또 번호가 존재합니다."),
    ERROR_LOTTO_NUMBER_RANGE_OVER(
            "로또 번호의 범위를 벗어났습니다. ( " + MIN_RANGE.getConfig() + " ~ " + MAX_RANGE.getConfig() + " )"),

    // 구매 금액 에러
    ERROR_LESS_THAN_MIN_AMOUNT("구매 금액이 최소 구매 금액(" + MIN_PRICE.getConfig() + "원)보다 미만입니다."),
    ERROR_GREATER_THAN_MAX_AMOUNT("구매 금액이 최대 구매 금액(" + MAX_PRICE.getConfig() + "원)보다 초과 되었습니다."),
    ERROR_DIVIDE_BY_AMOUNT("구매 금액이 " + MIN_PRICE.getConfig() + "원으로 나누어 떨어지지 않습니다."),
    ERROR_QUANTITY_NON_EQUALS("구매 요청 수량이 구매 수량과 일치하지 않습니다."),

    // 당첨 로또 번호 에러
    ERROR_LOTTO_NUMBER_FORMAT("입력 한 형식이 로또 번호 형식이 아닙니다.\n 입력 예) 1,2,3,4,5,6"),

    // 보너스 번호 에러
    ERROR_LOTTO_CONTAINS_BONUS("보너스 번호가 당첨 로또 번호에 중복됩니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
