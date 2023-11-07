package lotto.domain;

import static lotto.util.RandomLottoNumberGenerator.LOTTO_LOWER_BOUND;
import static lotto.util.RandomLottoNumberGenerator.LOTTO_UPPER_BOUND;

import java.util.Objects;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        if (number < LOTTO_LOWER_BOUND || LOTTO_UPPER_BOUND < number) {
            throw new IllegalArgumentException(Lotto.LOTTO_NUMBER_BOUNDARY_ERROR);
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber that)) {
            return false;
        }
        return getNumber() == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }

}
