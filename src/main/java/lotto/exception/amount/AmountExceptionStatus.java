package lotto.exception.amount;

import lotto.exception.ExceptionStatus;

public enum AmountExceptionStatus implements ExceptionStatus {

    READ_IS_NULL("NULL 은 입력할 수 없습니다."),
    READ_IS_NOT_NUMERIC("숫자만 입력할 수 있습니다."),

    AMOUNT_IS_NOT_POSITIVE("양의 정수만 입력할 수 있습니다."),
    AMOUNT_IS_OUT_OF_RANGE("10만원 까지 입력 가능합니다."),
    AMOUNT_IS_NOT_AVAILABLE("1000원 단위로 입력 가능합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String MESSAGE_PREFIX = "구입 금액은 ";
    private static final String MESSAGE_SUFFIX = "다시 입력해 주세요.";

    private final String message;

    AmountExceptionStatus(final String message) {
        this.message = ERROR_PREFIX + MESSAGE_PREFIX + message + MESSAGE_SUFFIX;
    }

    public String getMessage() {
        return this.message;
    }
}
