package lotto.view.message.exception;

import lotto.view.constant.OutputConstant;

public enum UserMoneyInputExceptionMessage {
    INPUT_IS_EMPTY(OutputConstant.ERROR_WARNING + "비어있는 입력값 입니다." + OutputConstant.NEW_LINE),
    USER_MONEY_IS_NOT_NUMERIC_TYPE(OutputConstant.ERROR_WARNING + "구입금액은 숫자 형식의 입력이어야 합니다." + OutputConstant.NEW_LINE),
    USER_MONEY_IS_NOT_DIVISIBLE_WITH_LOTTO_PRICE(
            OutputConstant.ERROR_WARNING + "구입금액이 로또 금액으로 나누어 떨어지지 않습니다." + OutputConstant.NEW_LINE);
    private final String message;

    UserMoneyInputExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
