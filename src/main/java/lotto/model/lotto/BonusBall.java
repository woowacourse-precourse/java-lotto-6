package lotto.model.lotto;

import lotto.common.constants.LottoRule;
import lotto.common.exception.ErrorMessage;

public record BonusBall(int number) {
    public BonusBall {
        validateLottoNumberRange(number);
    }

    private void validateLottoNumberRange(int number) {
        if (number < LottoRule.LOTTO_NUMBER_MIN.value || LottoRule.LOTTO_NUMBER_MAX.value < number) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getValue(number));
        }
    }
}
