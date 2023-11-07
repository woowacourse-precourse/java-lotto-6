package lotto.model;

import lotto.common.constants.LottoRule;
import lotto.common.exception.LottoErrorMessage;

public class BonusBall {
    private final int number;

    public BonusBall(int number) {
        validateLottoNumberRange(number);
        this.number = number;
    }

    private void validateLottoNumberRange(int number) {
        if (number < LottoRule.LOTTO_NUMBER_MIN.value || LottoRule.LOTTO_NUMBER_MAX.value < number) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getValue(number));
        }
    }

    public int getNumber() {
        return number;
    }
}
