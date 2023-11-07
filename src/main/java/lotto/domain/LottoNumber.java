package lotto.domain;

import static lotto.domain.LottoRule.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoRule.MIN_LOTTO_NUMBER;
import static lotto.view.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int value;

    private LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    public static LottoNumber from(int value) {
        return new LottoNumber(value);
    }

    public int getValue() {
        return value;
    }

    private void validate(int value) {
        validateRange(value);
    }

    private void validateRange(int value) {
        if (value < MIN_LOTTO_NUMBER.getValue() || value > MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getErrorMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber lottoNumber = (LottoNumber) o;
        return value == lottoNumber.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.value, o.value);
    }
}