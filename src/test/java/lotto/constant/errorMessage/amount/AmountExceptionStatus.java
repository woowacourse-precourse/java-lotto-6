package lotto.constant.errorMessage.amount;

import lotto.constant.errorMessage.ExceptionStatus;

public enum AmountExceptionStatus implements ExceptionStatus {

    AMOUNT_IS_NOT_NUMERIC("숫자만 입력할 수 있습니다."),
    AMOUNT_IS_NULL("NULL 이 입력될 수 없습니다.");

    private static final String MESSAGE_PREFIX = "[ERROR] 구입 금액은";
    private final String message;

    AmountExceptionStatus(final String message) {
        this.message = MESSAGE_PREFIX + message;
    }

    public String getMessage() {
        return this.message;
    }
}
