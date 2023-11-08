package lotto.domain.lotto;

import java.util.Objects;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    protected final int number;

    public LottoNumber(final int number) {
        validateNumberInRange(number);
        this.number = number;
    }

    private void validateNumberInRange(final int number) {
        if (number < MIN_NUMBER) {
            throw LottoException.of(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
        }

        if (number > MAX_NUMBER) {
            throw LottoException.of(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (other == null) {
            return false;
        }

        if (!(other instanceof LottoNumber otherLottoNumber)) {
            return false;
        }

        return number == otherLottoNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
