package lotto.model;


import static lotto.model.LottoAttribute.MAX_LOTTO_NUMBER;
import static lotto.model.LottoAttribute.MIN_LOTTO_NUMBER;
import static lotto.model.ErrorType.*;

import java.util.Objects;

public class LottoNumber {

    private final int number;

    private LottoNumber(final int number) {
        validate(number);
        this.number = number;
    }

    private void validate(final int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(final int number) {
        return number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
    }

    public static LottoNumber of(final int number) {
        return new LottoNumber(number);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoNumber other = (LottoNumber) o;
        return matchNumber(other);
    }

    private boolean matchNumber(final LottoNumber other) {
        return number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
