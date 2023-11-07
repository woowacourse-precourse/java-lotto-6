package lotto.model;

import lotto.exception.business.BusinessConditionException;

import static lotto.constant.LottoConfig.LOTTO_END_NUMBER;
import static lotto.constant.LottoConfig.LOTTO_START_NUMBER;
import static lotto.view.message.ValidationErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < LOTTO_START_NUMBER.getValue() || number > LOTTO_END_NUMBER.getValue()) {
            throw new BusinessConditionException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
