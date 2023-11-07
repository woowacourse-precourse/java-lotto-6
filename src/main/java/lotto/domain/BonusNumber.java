package lotto.domain;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConstant;

public class BonusNumber {

    private final Integer value;

    public BonusNumber(final Integer value) {
        validateNumberRange(value);
        this.value = value;
    }

    public Integer toValue() {
        return value;
    }

    public void validateNumberRange(final Integer value) {
        if (value > LottoConstant.MAX_LOTTO_NUMBER_RANGE || value < LottoConstant.MIN_LOTTO_NUMBER_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE.toMessage());
        }
    }
}
