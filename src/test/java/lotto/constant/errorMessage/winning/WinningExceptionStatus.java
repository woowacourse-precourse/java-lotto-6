package lotto.constant.errorMessage.winning;

import lotto.constant.errorMessage.ExceptionStatus;

public enum WinningExceptionStatus implements ExceptionStatus {

    BONUS_NUMBER_IS_DUPLICATED("당첨 번호와 중복될 수 없습니다."),
    BONUS_NUMBER_IS_OUT_OF_RANGE("1부터 45까지의 숫자만 가능합니다.");

    private static final String MESSAGE_ERROR = "[ERROR]";
    private static final String MESSAGE_PREFIX = " 보너스 번호는 ";
    private final String message;

    WinningExceptionStatus(final String message) {
        this.message = MESSAGE_ERROR + MESSAGE_PREFIX + message;
    }

    public String getMessage() {
        return this.message;
    }
}
