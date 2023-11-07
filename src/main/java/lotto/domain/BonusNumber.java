package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.exception.ModelExceptionConstant;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validateOutOfRange(number, LottoConstant.START_LOTTO_NUMBER.value(), LottoConstant.END_LOTTO_NUMBER.value());
        this.number = number;
    }

    private void validateOutOfRange(int number, int startNumber, int endNumber) {
        if (number < startNumber) {
            throw new IllegalArgumentException(ModelExceptionConstant.UNDER_LOTTO_START_NUMBER.getText());
        }

        if (number > endNumber) {
            throw new IllegalArgumentException(ModelExceptionConstant.UPPER_LOTTO_END_NUMBER.getText());
        }
    }
}
