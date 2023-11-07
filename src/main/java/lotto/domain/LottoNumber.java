package lotto.domain;

import java.util.Objects;

import static lotto.domain.LottoNumberGenerator.END_INCLUSIVE;
import static lotto.domain.LottoNumberGenerator.START_INCLUSIVE;
import static lotto.exception.ExceptionMessage.LOTTO_NUMBER_RANGE;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public void validateNumberRange(int number) {
        if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
            throw LOTTO_NUMBER_RANGE.getException(START_INCLUSIVE, END_INCLUSIVE);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
