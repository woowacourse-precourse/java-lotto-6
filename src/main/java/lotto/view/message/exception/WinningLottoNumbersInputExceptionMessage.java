package lotto.view.message.exception;

import lotto.view.constant.InputConstant;
import lotto.view.constant.OutputConstant;

public enum WinningLottoNumbersInputExceptionMessage {
    INPUT_IS_EMPTY(OutputConstant.ERROR_WARNING + "비어있는 입력값 입니다." + OutputConstant.NEW_LINE),
    WINNING_LOTTO_NUMBERS_DOES_NOT_CONTAIN_DELIMITER(
            OutputConstant.ERROR_WARNING + "당첨번호는 " + InputConstant.COMMA_SYMBOL + "("
                    + InputConstant.WINNING_LOTTO_NUMBERS_DELIMITER + ")를 기준으로 입력해주셔야 합니다." + OutputConstant.NEW_LINE),
    WINNING_LOTTO_NUMBERS_DOES_NOT_CONTAIN_SIX_NUMBERS(
            OutputConstant.ERROR_WARNING + "입력된 당첨번호가 6개가 아닙니다." + OutputConstant.NEW_LINE),
    WINNING_LOTTO_NUMBERS_CONTAINS_EMPTY_NUMBER(
            OutputConstant.ERROR_WARNING + "입력된 당첨번호 중 비어있는 값이 존재합니다." + OutputConstant.NEW_LINE),
    WINNING_LOTTO_NUMBERS_INPUT_EXCEED_INPUT_RANGE(
            OutputConstant.ERROR_WARNING + "입력된 당첨번호 중 입력값의 범위를 초과하는 값이 존재합니다." + OutputConstant.NEW_LINE),
    WINNING_LOTTO_NUMBER_IS_NOT_NUMERIC_TYPE(
            OutputConstant.ERROR_WARNING + "당첨번호가 숫자 형식의 입력이 아닙니다." + OutputConstant.NEW_LINE);

    private final String message;

    WinningLottoNumbersInputExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}