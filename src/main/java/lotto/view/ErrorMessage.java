package lotto.view;

import lotto.domain.Money;

public enum ErrorMessage {
    INVALID_PURCHASE_AMOUNT("0원 이상의 "+ Money.UNIT + "원 단위의 금액을 입력해주세요.");

    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
