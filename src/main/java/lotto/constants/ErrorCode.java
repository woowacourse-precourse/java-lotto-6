package lotto.constants;

import static lotto.constants.LottoRule.LOTTO_MAX_SIZE;
import static lotto.constants.LottoRule.UNIT_PRICE;

public enum ErrorCode {
    PREFIX("[ERROR] "),
    NOT_INTEGER("입력한 값이 숫자가 아닙니다."),
    NOT_DIVIDED(UNIT_PRICE.getValue() + "원 단위가 아닙니다."),
    INVALID_PURCHASE_AMOUNT("로또 구입금액의 범위가 유효하지 않습니다."),
    INVALID_LOTTO_NUMBER("로또 숫자의 범위가 유효하지 않습니다."),
    INVALID_LOTTO_SIZE("로또 티켓 하나에는 " + LOTTO_MAX_SIZE.getValue() + "개의 번호가 존재해야 합니다."),
    DUPLICATED_LOTTO_NUMBER("중복된 로또 번호가 있습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + this.message;
    }
}
