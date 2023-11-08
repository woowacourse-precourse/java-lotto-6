package lotto.domain;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConstant;

public class BonusNumber {

    private final int value;

    public BonusNumber(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int number) {
        if (!(LottoConstant.START_NUMBER.getValue() <= number && number <= LottoConstant.END_NUMBER.getValue())) {
            ExceptionMessage exceptionMessage = ExceptionMessage.INCORRECT_RANGE;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
