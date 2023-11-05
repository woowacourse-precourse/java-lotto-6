package lotto.domain;

import static lotto.common.ErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE;

import java.util.Objects;
import lotto.exception.InputValidationException;

public class LottoNumber {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (!isLottoNumberRange(number)) {
            throw new InputValidationException(LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    private boolean isLottoNumberRange(int number) {
        return number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber lottoNumber1)) {
            return false;
        }
        return getNumber() == lottoNumber1.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
