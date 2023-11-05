package lotto.domain;

import static lotto.ErrorMassage.IS_OUT_OF_RANGE_LOTTO_NUMBER;
import static lotto.domain.LottoConfig.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoConfig.LOTTO_MIN_NUMBER;

public class LottoNumber {
    private final int number;

    public LottoNumber(final int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(final int number) {
        if (number < LOTTO_MIN_NUMBER.getValue() || number > LOTTO_MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(IS_OUT_OF_RANGE_LOTTO_NUMBER.getMassage());
        }
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LottoNumber lottoNumber) {
            return this.number == lottoNumber.number;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
