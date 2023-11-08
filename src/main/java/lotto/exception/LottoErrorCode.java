package lotto.exception;

import static lotto.constants.LottoConstants.*;

public enum LottoErrorCode implements ErrorCode {

    DUPLICATED_NUMBER("로또 숫자는 중복된 로또 번호가 없어야 합니다."),
    NOT_ENOUGH_MONEY("로또 구입 최소 가격은 " + LOTTO_PRICE + "원입니다."),
    WRONG_PRICE("로또 구입 가격은 정확히 나누어 떨어져야 합니다."),

    INVALID_LENGTH("로또 숫자는 총 " + LOTTO_LENGTH + " 개여야 합니다."),
    OUT_OF_RANGE("로또 번호는 " + LOTTO_MIN + "부터 " + LOTTO_MAX + " 사이의 숫자여야 합니다."),

    NOT_FOUND_KEY("해당 키 구매내역을 찾을 수 없습니다."),

    ;

    static final String PREFIX = "[ERROR] ";

    final String message;


    LottoErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return PREFIX + message;
    }

}
