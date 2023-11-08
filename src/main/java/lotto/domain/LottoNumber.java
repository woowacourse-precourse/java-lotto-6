package lotto.domain;

import static lotto.constant.ErrorMessage.LOTTO_NUMBER_OVER_RANGE;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        validateNumberInRange(number);
        this.number = number;
    }

    private void validateNumberInRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OVER_RANGE);
        }
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        if (this.number > lottoNumber.number) {
            return 1;
        }
        return -1;
    }
}
