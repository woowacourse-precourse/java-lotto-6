package lotto.model;

import static lotto.model.ErrorType.LOTTO_NUMBER_OUT_OF_RANGE;

import java.util.Objects;

public class LottoNumber {

    private static final int MIN = 1;
    private static final int MAX = 45;

    private final int number;

    private LottoNumber(final int number) {
        validate(number);
        this.number = number;
    }

    private void validate(final int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(final int number) {
        return number < MIN || number > MAX;
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
}
