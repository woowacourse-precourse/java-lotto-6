package lotto.domain.lotto.entity;

import java.util.Objects;
import lotto.exception.LottoException;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int LOTTO_RANGE_MAX = 45;
    public static final int LOTTO_RANGE_MIN = 1;
    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number < LOTTO_RANGE_MIN || number > LOTTO_RANGE_MAX) {
            throw LottoException.LOTTO_NUMBER_OUT_RANGE.makeException();
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
