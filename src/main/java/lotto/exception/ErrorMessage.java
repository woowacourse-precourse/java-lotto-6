package lotto.exception;

import static lotto.global.Configuration.LIMIT_PRICE;
import static lotto.global.Configuration.MAXIMUM_RANGE_VALUE;
import static lotto.global.Configuration.MINIMUM_RANGE_VALUE;
import static lotto.global.Configuration.PICK_COUNT;
import static lotto.global.Configuration.PRICE_UNIT;

public enum ErrorMessage {
    CAPTION("[ERROR]"),
    UNDER_LIMIT(LIMIT_PRICE + "원 미만의 금액은 입력할 수 없습니다."),
    NON_REQUIRED_UNIT(PRICE_UNIT + "원 단위의 금액만 입력할 수 있습니다."),
    NOT_REQUIRED_LENGTH("당첨 번호는 " + PICK_COUNT + "개를 입력해야 합니다."),
    NON_NUMERIC_VALUE("숫자 이외의 값은 입력할 수 없습니다."),
    IS_EXISTED_VALUE("당첨 번호로 입력한 숫자는 다시 입력할 수 없습니다."),
    OUT_OF_RANGE(MINIMUM_RANGE_VALUE + "부터 " + MAXIMUM_RANGE_VALUE + "까지의 숫자만 입력할 수 있습니다."),
    HAS_DUPLICATION("서로 중복되는 숫자는 입력할 수 없습니다.");


    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return CAPTION.message + message;
    }
}
