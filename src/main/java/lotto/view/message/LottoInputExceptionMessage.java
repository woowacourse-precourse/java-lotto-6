package lotto.view.message;

import lotto.constant.LottoConstant;
import lotto.view.constant.InputConstant;
import lotto.view.constant.OutputConstant;

public enum LottoInputExceptionMessage {
    INPUT_IS_EMPTY(OutputConstant.ERROR_WARNING + "비어있는 입력값 입니다." + OutputConstant.NEW_LINE),
    USER_MONEY_IS_NOT_NUMERIC_TYPE(OutputConstant.ERROR_WARNING + "구입금액은 숫자 형식의 입력이어야 합니다." + OutputConstant.NEW_LINE),
    USER_MONEY_IS_NOT_DIVISIBLE_WITH_LOTTO_PRICE(
            OutputConstant.ERROR_WARNING + "구입금액이 로또 금액으로 나누어 떨어지지 않습니다." + OutputConstant.NEW_LINE),
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
            OutputConstant.ERROR_WARNING + "당첨번호가 숫자 형식의 입력이 아닙니다." + OutputConstant.NEW_LINE),
    LOTTO_NUMBERS_SIZE_IS_NOT_SIX(OutputConstant.ERROR_WARNING + "로또번호 입력이 6개가 아닙니다." + OutputConstant.NEW_LINE),
    LOTTO_NUMBERS_ARE_DUPLICATED(
            OutputConstant.ERROR_WARNING + "로또 번호에 중복된 값이 존재합니다." + OutputConstant.NEW_LINE),
    LOTTO_NUMBER_IS_NOT_IN_APPROPRIATE_RANGE(
            OutputConstant.ERROR_WARNING + "로또 번호는 " + LottoConstant.LOTTO_MIN_NUM.getValue() + "부터 "
                    + LottoConstant.LOTTO_MAX_NUM.getValue() + " 사이의 숫자여야 합니다." + OutputConstant.NEW_LINE),
    BONUS_NUMBER_IS_NOT_NUMERIC_TYPE(
            OutputConstant.ERROR_WARNING + "보너스 숫자는 숫자 형식의 입력이어야 합니다." + OutputConstant.NEW_LINE),
    BONUS_NUMBER_INPUT_EXCEED_INPUT_RANGE(
            OutputConstant.ERROR_WARNING + "보너스 숫자 입력이 입력값의 범위를 초과합니다." + OutputConstant.NEW_LINE),
    BONUS_NUMBER_IS_DUPLICATED_WITH_WINNING_LOTTO_NUMBERS(
            OutputConstant.ERROR_WARNING + "보너스 숫자가 당첨 숫자와 중복됩니다." + OutputConstant.NEW_LINE);

    private final String message;

    LottoInputExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}