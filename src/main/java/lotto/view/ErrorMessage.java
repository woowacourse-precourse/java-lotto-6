package lotto.view;

import static lotto.model.SystemConstant.LOTTO_PRICE;
import static lotto.model.SystemConstant.MAX_LOTTO_NUMBER;
import static lotto.model.SystemConstant.MIN_LOTTO_NUMBER;
import static lotto.model.SystemConstant.MIN_PURCHASE_PRICE;
import static lotto.model.SystemConstant.NUM_OF_NUMBERS;

import java.text.DecimalFormat;

public enum ErrorMessage {
    NOT_NUMBER("유효한 숫자를 입력해야 합니다."),
    LESS_MONEY("구입금액은 " + new DecimalFormat("###,###").format(MIN_PURCHASE_PRICE) + "원 이상 필요합니다."),
    NOT_DIVISIBLE_MONEY("구입금액은 " + new DecimalFormat("###,###").format(LOTTO_PRICE) + "원 단위로 나눠져야 합니다."),
    NOT_LIST("쉼표로 구분해서 작성해야 합니다."),
    NOT_EQUAL_NUM_OF_NUMBERS(NUM_OF_NUMBERS + "개의 숫자를 입력해야 합니다."),
    OUT_OF_RANGE_LOTTO_NUMBERS("로또 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + " 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER("로또는 중복되지 않은 번호들로 구성되어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
