package lotto.constant.errorMessage.lotto;

import lotto.constant.errorMessage.ExceptionStatus;

public enum LottoExceptionStatus implements ExceptionStatus {

    LOTTO_NUMBER_IS_DUPLICATED("중복될 수 없습니다.");

    private static final String MESSAGE_ERROR = "[ERROR]";
    private static final String MESSAGE_PREFIX = " 로또 번호는 ";
    private final String message;

    LottoExceptionStatus(final String message) {
        this.message = MESSAGE_ERROR + MESSAGE_PREFIX + message;
    }

    public String getMessage() {
        return this.message;
    }
}
