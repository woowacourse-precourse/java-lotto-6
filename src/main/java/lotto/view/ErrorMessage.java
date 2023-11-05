package lotto.view;

import static lotto.model.SystemConstant.LOTTO_PRICE;
import static lotto.model.SystemConstant.MIN_PURCHASE_PRICE;

import java.text.DecimalFormat;

public enum ErrorMessage {
    NOT_NUMBER("숫자를 입력해주세요."),
    LESS_MONEY("구입금액은 " + new DecimalFormat("###,###").format(MIN_PURCHASE_PRICE) + "원 이상 필요합니다."),
    NOT_DIVISIBLE_MONEY("구입금액은 " + new DecimalFormat("###,###").format(LOTTO_PRICE) + "원 단위로 나눠져야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
