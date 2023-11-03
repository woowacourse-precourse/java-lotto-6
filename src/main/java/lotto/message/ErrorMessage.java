package lotto.message;

import static lotto.constants.SystemOption.PAYMENT_UNIT_VALUE;

public enum ErrorMessage {
    NOT_NUMBER_ERROR_MESSAGE("올바른 숫자 형식으로 입력해주세요."),
    NOT_POSITIVE_ERROR_MESSAGE("양수 값을 입력해주세요."),
    WRONG_UNIT_ERROR_MESSAGE(PAYMENT_UNIT_VALUE.getValue() + " 단위로 금액을 입력해주세요.");

    private String content;

    ErrorMessage(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.content;
    }
}
