package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.constant.message.ExceptionMessage;

public class BonusNumber {

    private final Integer value;

    public BonusNumber(final Integer value) {
        validateNumberRange(value);
        this.value = value;
    }

    public Integer toValue() {
        return value;
    }

    private void validateNumberRange(final Integer value) {
        if (value > LottoConstant.MAX_LOTTO_NUMBER_RANGE || value < LottoConstant.MIN_LOTTO_NUMBER_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE.toMessage());
        }
    }
}
