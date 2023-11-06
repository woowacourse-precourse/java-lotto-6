package lotto.constant.errorMessage.amount;

import lotto.constant.errorMessage.ExceptionStatus;

public enum AmountExceptionStatus implements ExceptionStatus {

    AMOUNT_IS_NOT_NUMERIC("숫자만 입력할 수 있습니다."),
    AMOUNT_IS_NULL("NULL 이 입력될 수 없습니다."),
    AMOUNT_IS_NOT_POSITIVE("양의 정수만 입력될 수 있습니다."),
    AMOUNT_IS_NOT_DIVISIBLE("1000 단위로 나누어 떨어지는 숫자만 입력될 수 있습니다.");



    private static final String MESSAGE_ERROR = "[ERROR]";
    private static final String MESSAGE_PREFIX = " 구입 금액은 ";
    private final String message;

    AmountExceptionStatus(final String message) {
        this.message = MESSAGE_ERROR + MESSAGE_PREFIX + message;
    }

    public String getMessage() {
        return this.message;
    }
}
