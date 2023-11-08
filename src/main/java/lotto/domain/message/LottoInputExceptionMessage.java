package lotto.domain.message;

import lotto.constant.LottoConstant;
import lotto.view.constant.OutputConstant;

public enum LottoInputExceptionMessage {
    LOTTO_NUMBERS_SIZE_IS_NOT_SIX(OutputConstant.ERROR_WARNING + "로또번호 입력이 6개가 아닙니다." + OutputConstant.NEW_LINE),
    LOTTO_NUMBERS_ARE_DUPLICATED(
            OutputConstant.ERROR_WARNING + "로또 번호에 중복된 값이 존재합니다." + OutputConstant.NEW_LINE),
    LOTTO_NUMBER_IS_NOT_IN_APPROPRIATE_RANGE(
            OutputConstant.ERROR_WARNING + "로또 번호는 " + LottoConstant.LOTTO_MIN_NUM.getValue() + "부터 "
                    + LottoConstant.LOTTO_MAX_NUM.getValue() + " 사이의 숫자여야 합니다." + OutputConstant.NEW_LINE);
    private final String message;

    LottoInputExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}