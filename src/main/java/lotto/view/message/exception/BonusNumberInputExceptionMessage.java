package lotto.view.message.exception;

import lotto.view.constant.OutputConstant;

public enum BonusNumberInputExceptionMessage {
    INPUT_IS_EMPTY(OutputConstant.ERROR_WARNING + "비어있는 입력값 입니다." + OutputConstant.NEW_LINE),
    BONUS_NUMBER_IS_NOT_NUMERIC_TYPE(
            OutputConstant.ERROR_WARNING + "보너스 숫자는 숫자 형식의 입력이어야 합니다." + OutputConstant.NEW_LINE),
    BONUS_NUMBER_INPUT_EXCEED_INPUT_RANGE(
            OutputConstant.ERROR_WARNING + "보너스 숫자 입력이 입력값의 범위를 초과합니다." + OutputConstant.NEW_LINE),
    BONUS_NUMBER_IS_DUPLICATED_WITH_WINNING_LOTTO_NUMBERS(
            OutputConstant.ERROR_WARNING + "보너스 숫자가 당첨 숫자와 중복됩니다." + OutputConstant.NEW_LINE);

    private final String message;

    BonusNumberInputExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
